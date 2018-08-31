package tk.clawhub.core;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.cache.PathChildrenCache;
import org.apache.curator.framework.recipes.cache.PathChildrenCacheEvent;
import org.apache.zookeeper.data.Stat;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.clawhub.alarm.AlarmMonitor;
import tk.clawhub.mail.EmailSender;
import tk.clawhub.util.ZkUtil;

import javax.annotation.PostConstruct;
import java.util.ArrayList;
import java.util.List;

/**
 * <Description> 父监控节点 <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018 -08-07 <br>
 */
@Component
public class ParentAlarmMonitor {
    /**
     * The Alarm monitor.
     */
    @Autowired
    private AlarmMonitor alarmMonitor;
    /**
     * The Leader selector.
     */
    @Autowired
    private LeaderSelector leaderSelector;
    /**
     * The Client.
     */
    private CuratorFramework client;
    /**
     * The Parent path.
     */
    private String parentPath;

    /**
     * The Email sender.
     */
    @Autowired
    private EmailSender emailSender;

    /**
     * Init.
     */
    @PostConstruct
    public void init() {
        //zk客户端
        client = alarmMonitor.getClient();
        //父路经
        parentPath = alarmMonitor.getParentPath();
        //检查父路经
        checkParentPath();
        //创建孩子节点监控
        createListener();
    }

    /**
     * 检查父路经
     */
    private void checkParentPath() {
        try {
            Stat flag = client.checkExists().forPath(parentPath);
            //节点不存在
            if (flag == null) {
                //创建节点
                ZkUtil.createPath(client, parentPath);
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


    /**
     * 创建孩子节点监控
     */
    private void createListener() {
        //创建节点
        PathChildrenCache pathChildrenCache = new PathChildrenCache(client, parentPath, true);
        try {
            pathChildrenCache.start(PathChildrenCache.StartMode.POST_INITIALIZED_EVENT);
        } catch (Exception e) {
            e.printStackTrace();
        }
        pathChildrenCache.getListenable().addListener((client, event) -> {
            //如果当前是主节点，处理监听
            if (leaderSelector.isLeader()) {
                //处理监听
                process(event);
            }

        });
    }

    /**
     * Process.
     *
     * @param event the event
     */
    private void process(PathChildrenCacheEvent event) {
        System.out.println("事件类型：" + event.getType());
        System.out.println("操作节点：" + event.getData());
        String content = "";
        if (PathChildrenCacheEvent.Type.CHILD_ADDED.equals(event.getType())) {
            content = "爬虫节点注册成功。\n节点路径：" + event.getData().getPath();
        } else if (PathChildrenCacheEvent.Type.CHILD_REMOVED.equals(event.getType())) {
            content = "爬虫节点下线。\n节点路径：" + event.getData().getPath();
        }
        sendEmail(content);
    }

    /**
     * Send email.
     *
     * @param content the content
     */
    private void sendEmail(String content) {
        List<String> addressList = new ArrayList<>();
        addressList.add("874070898@qq.com");
        addressList.add("lizhimingdc@gmail.com");
        emailSender.send("爬虫监控", content, addressList);
    }
}
