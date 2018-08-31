package tk.clawhub.proxy;


import tk.clawhub.model.Page;
import tk.clawhub.model.Task;

/**
 * <Description>Proxy provider <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @date 2018 -07-24 <br>
 */
public interface IProxyProvider {

    /**
     * Gets proxy.
     *
     * @param task the task
     * @return the proxy
     */
    Proxy getProxy(Task task);

    /**
     * Return proxy.
     *
     * @param proxy the proxy
     * @param page  the page
     * @param task  the task
     */
    void returnProxy(Proxy proxy, Page page, Task task);

}
