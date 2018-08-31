package tk.clawhub.core;

import org.apache.commons.lang3.StringUtils;
import org.apache.http.client.HttpClient;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.scheduling.concurrent.ThreadPoolTaskScheduler;
import org.springframework.scheduling.support.CronTrigger;
import org.springframework.stereotype.Component;
import tk.clawhub.service.IUrl;

import javax.annotation.PostConstruct;
import java.util.Map;

/**
 * <Description>Scheduler <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @date 2018 -07-26 <br>
 */
@Component
public class Scheduler {

    /**
     * The Logger.
     */
    private Logger logger = LoggerFactory.getLogger(this.getClass());
    /**
     * The Spring context helper.
     */
    @Autowired
    private SpringContextHelper springContextHelper;
    @Value("${url.scheduler.pool.size}")
    private int poolSize;

    /**
     * Init.
     */
    @PostConstruct
    public void init() {
        logger.info("init task.");
        //初始化任务池
        ThreadPoolTaskScheduler scheduler = new ThreadPoolTaskScheduler();
        scheduler.setPoolSize(poolSize);
        scheduler.initialize();
        //获取IUrl下所有的实现类
        Map<String, IUrl> map = springContextHelper.getServiceImplMap();
        String beanName;
        IUrl iUrl;
        String cron;
        for (Map.Entry<String, IUrl> entry : map.entrySet()) {
            beanName = entry.getKey();
            logger.info("task:{} is run.", beanName);
            iUrl = entry.getValue();
            cron = iUrl.getCron();
            //如果cron表达式为空，任务立马执行一次
            if (StringUtils.isBlank(cron)) {
                scheduler.execute(new TaskRunable(iUrl));
                continue;
            }
            //组装任务，将所有任务加到任务池
            scheduler.schedule(new TaskRunable(iUrl), new CronTrigger(cron));
        }

    }

    /**
     * <Description>Task runable <br>
     *
     * @author LiZhiming<br>
     * @version 1.0<br>
     * @taskId <br>
     * @date 2018 -07-26 <br>
     */
    private class TaskRunable implements Runnable {
        /**
         * The Url.
         */
        private IUrl iUrl;

        /**
         * Instantiates a new Task runable.
         *
         * @param iUrl the url
         */
        public TaskRunable(IUrl iUrl) {
            this.iUrl = iUrl;
        }

        @Override
        public void run() {
            iUrl.execute();
        }
    }
}
