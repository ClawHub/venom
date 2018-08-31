package tk.clawhub.downloader;

import tk.clawhub.model.Page;
import tk.clawhub.model.Request;
import tk.clawhub.model.Task;

/**
 * <Description>Idownloader <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @date 2018 -07-24 <br>
 */
public interface Idownloader {
    /**
     * Download page.
     *
     * @param request the request
     * @param task    the task
     * @return the page
     */
    Page download(Request request, Task task);

    /**
     * Sets thread.
     *
     * @param threadNum the thread num
     */
    void setThread(int threadNum);
}
