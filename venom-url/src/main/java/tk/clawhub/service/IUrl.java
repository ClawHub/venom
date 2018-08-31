package tk.clawhub.service;

/**
 * <Description>Url <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @date 2018 -07-26 <br>
 */
public interface IUrl {

    /**
     * Execute.
     */
    void execute();

    /**
     * Gets cron.
     * 如果cron表达式为空，任务立马执行一次
     *
     * @return the cron
     */
    String getCron();
}
