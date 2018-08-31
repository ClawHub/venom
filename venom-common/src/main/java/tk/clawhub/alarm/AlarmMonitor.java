package tk.clawhub.alarm;

import org.apache.curator.framework.CuratorFramework;
import org.apache.zookeeper.CreateMode;
import org.apache.zookeeper.data.Stat;
import org.springframework.stereotype.Component;
import tk.clawhub.util.SystemUtil;
import tk.clawhub.util.ZkUtil;

import javax.annotation.PostConstruct;

/**
 * <Description> <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018 -08-28 <br>
 */
@Component
public class AlarmMonitor {
    /**
     * The Client.
     */
    private CuratorFramework client;
    /**
     * The Parent path.
     */
    private String parentPath = "/alarm";

    /**
     * Init.
     */
    @PostConstruct
    public void init() {
        client = ZkUtil.getClient("120.55.241.117:2333", "venom");
    }

    /**
     * Gets client.
     *
     * @return the client
     */
    public CuratorFramework getClient() {
        return client;
    }

    /**
     * Gets parent path.
     *
     * @return the parent path
     */
    public String getParentPath() {
        return parentPath;
    }

    /**
     * 父节点下创建临时子节点，如果断开zk连接，子节点自动删除
     *
     * @param childName the child name
     */
    public void createChildNode(String childName) {
        String path = parentPath + "/" + SystemUtil.getHostName() + ":" + SystemUtil.getHostAddress() + ":" + childName;
        try {
            client.create().withMode(CreateMode.EPHEMERAL).forPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Check exists for parent path boolean.
     *
     * @return the boolean
     */
    public boolean checkExistsForParentPath() {
        try {
            Stat flag = client.checkExists().forPath(parentPath);
            if (flag == null) {
                return false;
            }
        } catch (Exception e) {
            return false;
        }
        return true;
    }
}
