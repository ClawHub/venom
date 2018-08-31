package tk.clawhub.processor;

import tk.clawhub.model.Page;
import tk.clawhub.url.Url;

/**
 * <Description>Iprocessor <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @date 2018 -07-25 <br>
 */
public interface Iprocessor {

    /**
     * Execute.
     *
     * @param page the page
     */
    void execute(Page page);

    /**
     * 解析页面中的url
     *
     * @param page the page
     */
    void parseUrl(Page page);
}
