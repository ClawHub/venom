package tk.clawhub.core;

import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.recipes.leader.LeaderLatch;
import org.apache.curator.framework.recipes.leader.Participant;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.scheduling.annotation.EnableScheduling;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import tk.clawhub.alarm.AlarmMonitor;
import tk.clawhub.util.IDGenarator;

import javax.annotation.PostConstruct;
import java.util.Collection;

/**
 * <Description> 选主<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018/8/28 <br>
 */
@Component
@EnableScheduling
public class LeaderSelector {
    /**
     * The constant log.
     */
    private static Logger log = LoggerFactory.getLogger(LeaderSelector.class);
    /**
     * The Client.
     */
    private CuratorFramework client;

    /**
     * The Leader latch.
     */
    private LeaderLatch leaderLatch;
    /**
     * The Alarm monitor.
     */
    @Autowired
    private AlarmMonitor alarmMonitor;

    /**
     * The Leader path.
     */
    private String leaderPath = "/alarm-monitor/leader";
    /**
     * The Server id.
     */
    private String serverId = "Client # " + IDGenarator.getID();
    /**
     * 是否是leader 默认为false
     */
    private boolean isLeader = false;

    @PostConstruct
    public void init() {
        //zk客户端
        client = alarmMonitor.getClient();
        leaderLatch = new LeaderLatch(client, leaderPath, serverId);
        try {
            leaderLatch.start();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * Description: 周期性选主 <br>
     *
     * @author LiZhiming <br>
     * @taskId <br>
     */
    @Scheduled(fixedDelayString = "3000")
    public void checkLeader() {
        log.info("==================checkLeader====================");
        try {
            //首先利用serverId检查自己是否还存在于leader latch选举结果集中
            //考虑网络阻塞，zk数据异常丢失等情况
            boolean isExist = false;
            Collection<Participant> participants = leaderLatch.getParticipants();
            for (Participant participant : participants) {
                if (serverId.equals(participant.getId())) {
                    isExist = true;
                    break;
                }
            }
            //如果不存在，则重新加入选举
            if (!isExist) {
                log.info("Current server does not exist on zk, reset leader latch");
                leaderLatch.close();
                leaderLatch = new LeaderLatch(client, leaderPath, serverId);
                leaderLatch.start();
                log.info("Successfully reset leader latch");
            }
            //查看当前leader是否是自己
            //注意，不能用leaderLatch.hasLeadership()因为有zk数据丢失的不确定性
            //利用serverId对比确认是否主为自己
            Participant leader = leaderLatch.getLeader();
            boolean hashLeaderShip = serverId.equals(leader.getId());
            if (hashLeaderShip) {
                isLeader = true;
            } else {
                isLeader = false;
            }
        } catch (Exception ex) {
            log.error("checkLeader Exception", ex);
        }
    }

    /**
     * Description: 判断是否为主 <br>
     *
     * @return boolean
     * @author LiZhiming <br>
     * @taskId <br>
     */
    public boolean isLeader() {
        return isLeader;
    }
}
