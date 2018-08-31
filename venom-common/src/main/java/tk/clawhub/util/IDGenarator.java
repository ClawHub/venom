/**************************************************************************************** 
 南京小视科技有限公司
 ****************************************************************************************/
package tk.clawhub.util;

import java.util.UUID;

/**
 * <Description>生成32位uuid <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @CreateDate 2018 -08-28 <br>
 */
public class IDGenarator {
    /**
     * Instantiates a new Id genarator.
     */
    private IDGenarator() {
    }

    /**
     * 生成32位uuid
     *
     * @return the id
     */
    public static String getID() {
        return UUID.randomUUID().toString().replaceAll("-", "");
    }

}
