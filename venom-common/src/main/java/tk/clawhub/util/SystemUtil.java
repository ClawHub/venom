package tk.clawhub.util;

import java.net.InetAddress;
import java.net.UnknownHostException;

/**
 * <Description> 系统工具<br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018/8/28 <br>
 */
public class SystemUtil {
    /**
     * The constant addr.
     */
    private static InetAddress addr;

    static {
        try {
            addr = InetAddress.getLocalHost();
        } catch (UnknownHostException e) {
            e.printStackTrace();
        }
    }

    /**
     * 获取本机ip
     *
     * @return the host address
     */
    public static String getHostAddress() {
        if (addr == null) {
            return "127.0.0.1";
        }
        return addr.getHostAddress();
    }

    /**
     * 获取本机计算机名称
     *
     * @return the host name
     */
    public static String getHostName() {
        if (addr == null) {
            return "localhost";
        }
        return addr.getHostName();
    }
}
