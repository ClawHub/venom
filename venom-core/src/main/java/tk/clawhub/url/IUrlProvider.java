package tk.clawhub.url;

import tk.clawhub.model.Page;
import tk.clawhub.model.Task;

/**
 * <Description>Url provider <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @date 2018 -07-25 <br>
 */
public interface IUrlProvider {
    /**
     * Gets url.
     *
     * @return the url
     */
    Url getUrl();

    /**
     * Return url.
     */
    void returnUrl(Url url, Page page, Task task);
}
