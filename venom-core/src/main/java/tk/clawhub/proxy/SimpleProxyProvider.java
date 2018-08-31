package tk.clawhub.proxy;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;
import tk.clawhub.model.Page;
import tk.clawhub.model.Task;

/**
 * <Description>Simple proxy provider <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @date 2018 -07-25 <br>
 */
@Component
public class SimpleProxyProvider implements IProxyProvider {
    /**
     * The Redis dao.
     */
//    @Autowired
//    private RedisDao redisDao;

    @Value("${venom.redis.key.ip.proxy.normal}")
    private String ipProxyNormalKey;

    @Override
    public Proxy getProxy(Task task) {
        //redis队列中获取 代理ip端口
        // String host = redisDao.rightPopFromList(ipProxyNormalKey);
        String host = "";
        if (StringUtils.isBlank(host)) {
            return null;
        }
        String[] arr = host.split(":");
        if (arr == null || arr.length < 2) {
            return null;
        }
        String ip = arr[0];
        int port = Integer.parseInt(arr[1]);
        return new Proxy(ip, port);
    }

    @Override
    public void returnProxy(Proxy proxy, Page page, Task task) {
        if (page.isDownloadSuccess()) {
            return;
        }
        //访问失败  代理入失败队列，url入队列
        //TODO


    }
}
