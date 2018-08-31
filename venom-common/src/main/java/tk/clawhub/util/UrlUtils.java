package tk.clawhub.util;


import org.apache.commons.lang3.StringUtils;

import java.nio.charset.Charset;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * <Description>Url utils <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @date 2018 -07-24 <br>
 */
public class UrlUtils {
    /**
     * The constant patternForProtocal.
     */
    private static Pattern patternForProtocal = Pattern.compile("[\\w]+://");
    /**
     * The constant patternForCharset.
     */
    private static final Pattern patternForCharset = Pattern.compile("charset\\s*=\\s*['\"]*([^\\s;'\"]*)", Pattern.CASE_INSENSITIVE);

    /**
     * Gets domain.
     *
     * @param url the url
     * @return the domain
     */
    public static String getDomain(String url) {
        String domain = removeProtocol(url);
        int i = StringUtils.indexOf(domain, "/", 1);
        if (i > 0) {
            domain = StringUtils.substring(domain, 0, i);
        }
        return removePort(domain);
    }

    /**
     * Remove protocol string.
     *
     * @param url the url
     * @return the string
     */
    public static String removeProtocol(String url) {
        return patternForProtocal.matcher(url).replaceAll("");
    }

    /**
     * Remove port string.
     *
     * @param domain the domain
     * @return the string
     */
    public static String removePort(String domain) {
        int portIndex = domain.indexOf(":");
        if (portIndex != -1) {
            return domain.substring(0, portIndex);
        } else {
            return domain;
        }
    }

    /**
     * Fix illegal character in url string.
     *
     * @param url the url
     * @return the string
     */
    public static String fixIllegalCharacterInUrl(String url) {
        return url.replace(" ", "%20").replaceAll("#+", "#");
    }

    /**
     * Gets charset.
     *
     * @param contentType the content type
     * @return the charset
     */
    public static String getCharset(String contentType) {
        Matcher matcher = patternForCharset.matcher(contentType);
        if (matcher.find()) {
            String charset = matcher.group(1);
            if (Charset.isSupported(charset)) {
                return charset;
            }
        }
        return null;
    }

}
