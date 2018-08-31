package tk.clawhub.util;

import org.apache.curator.RetryPolicy;
import org.apache.curator.framework.CuratorFramework;
import org.apache.curator.framework.CuratorFrameworkFactory;
import org.apache.curator.retry.ExponentialBackoffRetry;
import org.apache.zookeeper.CreateMode;

public class ZkUtil {
    /**
     * Gets client.
     *
     * @param connectString the connect string
     * @param namespace     the namespace
     * @return the client
     */
    public static CuratorFramework getClient(String connectString, String namespace) {
        RetryPolicy retryPolicy = new ExponentialBackoffRetry(1000, 3);
        CuratorFramework client = CuratorFrameworkFactory.builder()
                .connectString(connectString)
                .retryPolicy(retryPolicy)
                .sessionTimeoutMs(6000)
                .connectionTimeoutMs(3000)
                .namespace(namespace)
                .build();
        client.start();
        return client;
    }

    /**
     * Create path.
     *
     * @param client the client
     * @param path   the path
     */
    public static void createPath(CuratorFramework client, String path) {
        try {
            client.create().withMode(CreateMode.PERSISTENT).forPath(path);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }


}
