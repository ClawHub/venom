package tk.clawhub.alarm;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.clawhub.util.IDGenarator;

import javax.annotation.PostConstruct;

/**
 * <Description> 告警孩子节点注册<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018/8/28 <br>
 */
@Component
public class ChildRegister {
    /**
     * The Alarm monitor.
     */
    @Autowired
    private AlarmMonitor alarmMonitor;

    @PostConstruct
    public void init() {
        while (true) {
            if (alarmMonitor.checkExistsForParentPath()) {
                alarmMonitor.createChildNode(IDGenarator.getID());
                return;
            }
        }

    }

}
