package tk.clawhub.model;

import java.io.Serializable;
import java.util.HashMap;
import java.util.Map;

/**
 * <Description>Request <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @date 2018 -07-24 <br>
 */
public class Request implements Serializable {

    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 2062192774891352043L;

    /**
     * The constant CYCLE_TRIED_TIMES.
     */
    public static final String CYCLE_TRIED_TIMES = "_cycle_tried_times";

    /**
     * The Url.
     */
    private String url;

    /**
     * The Method.
     */
    private String method;

    /**
     * The Request body.
     */
    private HttpRequestBody requestBody;

    /**
     * The Extras.
     */
    private Map<String, Object> extras;

    /**
     * The Cookies.
     */
    private Map<String, String> cookies = new HashMap<String, String>();

    /**
     * The Headers.
     */
    private Map<String, String> headers = new HashMap<String, String>();

    /**
     * The Priority.
     */
    private long priority;

    /**
     * The Binary content.
     */
    private boolean binaryContent = false;

    /**
     * The Charset.
     */
    private String charset;

    /**
     * Gets serial version uid.
     *
     * @return the serial version uid
     */
    public static long getSerialVersionUID() {
        return serialVersionUID;
    }

    /**
     * Gets cycle tried times.
     *
     * @return the cycle tried times
     */
    public static String getCycleTriedTimes() {
        return CYCLE_TRIED_TIMES;
    }

    /**
     * Gets url.
     *
     * @return the url
     */
    public String getUrl() {
        return url;
    }

    /**
     * Sets url.
     *
     * @param url the url
     */
    public void setUrl(String url) {
        this.url = url;
    }

    /**
     * Gets method.
     *
     * @return the method
     */
    public String getMethod() {
        return method;
    }

    /**
     * Sets method.
     *
     * @param method the method
     */
    public void setMethod(String method) {
        this.method = method;
    }

    /**
     * Gets request body.
     *
     * @return the request body
     */
    public HttpRequestBody getRequestBody() {
        return requestBody;
    }

    /**
     * Sets request body.
     *
     * @param requestBody the request body
     */
    public void setRequestBody(HttpRequestBody requestBody) {
        this.requestBody = requestBody;
    }

    /**
     * Gets extras.
     *
     * @return the extras
     */
    public Map<String, Object> getExtras() {
        return extras;
    }

    /**
     * Sets extras.
     *
     * @param extras the extras
     */
    public void setExtras(Map<String, Object> extras) {
        this.extras = extras;
    }

    /**
     * Gets cookies.
     *
     * @return the cookies
     */
    public Map<String, String> getCookies() {
        return cookies;
    }

    /**
     * Sets cookies.
     *
     * @param cookies the cookies
     */
    public void setCookies(Map<String, String> cookies) {
        this.cookies = cookies;
    }

    /**
     * Gets headers.
     *
     * @return the headers
     */
    public Map<String, String> getHeaders() {
        return headers;
    }

    /**
     * Sets headers.
     *
     * @param headers the headers
     */
    public void setHeaders(Map<String, String> headers) {
        this.headers = headers;
    }

    /**
     * Gets priority.
     *
     * @return the priority
     */
    public long getPriority() {
        return priority;
    }

    /**
     * Sets priority.
     *
     * @param priority the priority
     */
    public void setPriority(long priority) {
        this.priority = priority;
    }

    /**
     * Is binary content boolean.
     *
     * @return the boolean
     */
    public boolean isBinaryContent() {
        return binaryContent;
    }

    /**
     * Sets binary content.
     *
     * @param binaryContent the binary content
     */
    public void setBinaryContent(boolean binaryContent) {
        this.binaryContent = binaryContent;
    }

    /**
     * Gets charset.
     *
     * @return the charset
     */
    public String getCharset() {
        return charset;
    }

    /**
     * Sets charset.
     *
     * @param charset the charset
     */
    public void setCharset(String charset) {
        this.charset = charset;
    }
}
