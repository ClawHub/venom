package tk.clawhub.core;

import org.springframework.beans.factory.InitializingBean;
import org.springframework.context.ApplicationContext;
import org.springframework.context.ApplicationContextAware;
import org.springframework.stereotype.Component;
import tk.clawhub.service.IUrl;

import java.util.HashMap;
import java.util.Map;

/**
 * <Description>Spring context helper <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @date 2018 -07-26 <br>
 */
@Component
public class SpringContextHelper implements InitializingBean, ApplicationContextAware {
    /**
     * The App ctx.
     */
    private ApplicationContext appCtx;
    /**
     * The Service impl map.
     */
    private Map<String, IUrl> serviceImplMap = new HashMap<>();

    /**
     * Description: Set application context <br>
     *
     * @param applicationContext application context
     * @author LiZhiming <br>
     * @taskId <br>
     */
    @Override
    public void setApplicationContext(ApplicationContext applicationContext) {
        appCtx = applicationContext;
    }


    @Override
    public void afterPropertiesSet() {
        serviceImplMap = appCtx.getBeansOfType(IUrl.class);

    }

    /**
     * Gets service impl map.
     *
     * @return the service impl map
     */
    public Map<String, IUrl> getServiceImplMap() {
        return serviceImplMap;
    }
}
