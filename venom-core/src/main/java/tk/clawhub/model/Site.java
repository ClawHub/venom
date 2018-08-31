package tk.clawhub.model;

import tk.clawhub.constant.HttpConstant;

import java.util.*;

/**
 * <Description>Site <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @date 2018 -07-24 <br>
 */
public class Site {

    /**
     * The Domain.
     */
    private String domain;

    /**
     * The User agent.
     */
    private String userAgent;

    /**
     * The Default cookies.
     */
    private Map<String, String> defaultCookies = new LinkedHashMap<String, String>();

    /**
     * The Cookies.
     */
    private Map<String, Map<String, String>> cookies = new HashMap<String, Map<String, String>>();

    /**
     * The Charset.
     */
    private String charset;

    /**
     * The Sleep time.
     */
    private int sleepTime = 5000;

    /**
     * The Retry times.
     */
    private int retryTimes = 0;

    /**
     * The Cycle retry times.
     */
    private int cycleRetryTimes = 0;

    /**
     * The Retry sleep time.
     */
    private int retrySleepTime = 1000;

    /**
     * The Time out.
     */
    private int timeOut = 5000;

    /**
     * The constant DEFAULT_STATUS_CODE_SET.
     */
    private static final Set<Integer> DEFAULT_STATUS_CODE_SET = new HashSet<Integer>();

    /**
     * The Accept stat code.
     */
    private Set<Integer> acceptStatCode = DEFAULT_STATUS_CODE_SET;

    /**
     * The Headers.
     */
    private Map<String, String> headers = new HashMap<String, String>();

    /**
     * The Use gzip.
     */
    private boolean useGzip = true;

    /**
     * The Disable cookie management.
     */
    private boolean disableCookieManagement = false;

    static {
        DEFAULT_STATUS_CODE_SET.add(HttpConstant.StatusCode.CODE_200);
    }

    /**
     * Gets domain.
     *
     * @return the domain
     */
    public String getDomain() {
        return domain;
    }

    /**
     * Sets domain.
     *
     * @param domain the domain
     */
    public void setDomain(String domain) {
        this.domain = domain;
    }

    /**
     * Gets user agent.
     *
     * @return the user agent
     */
    public String getUserAgent() {
        return userAgent;
    }

    /**
     * Sets user agent.
     *
     * @param userAgent the user agent
     */
    public void setUserAgent(String userAgent) {
        this.userAgent = userAgent;
    }

    /**
     * Gets default cookies.
     *
     * @return the default cookies
     */
    public Map<String, String> getDefaultCookies() {
        return defaultCookies;
    }

    /**
     * Sets default cookies.
     *
     * @param defaultCookies the default cookies
     */
    public void setDefaultCookies(Map<String, String> defaultCookies) {
        this.defaultCookies = defaultCookies;
    }

    /**
     * Gets cookies.
     *
     * @return the cookies
     */
    public Map<String, Map<String, String>> getCookies() {
        return cookies;
    }

    /**
     * Sets cookies.
     *
     * @param cookies the cookies
     */
    public void setCookies(Map<String, Map<String, String>> cookies) {
        this.cookies = cookies;
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

    /**
     * Gets sleep time.
     *
     * @return the sleep time
     */
    public int getSleepTime() {
        return sleepTime;
    }

    /**
     * Sets sleep time.
     *
     * @param sleepTime the sleep time
     */
    public void setSleepTime(int sleepTime) {
        this.sleepTime = sleepTime;
    }

    /**
     * Gets retry times.
     *
     * @return the retry times
     */
    public int getRetryTimes() {
        return retryTimes;
    }

    /**
     * Sets retry times.
     *
     * @param retryTimes the retry times
     */
    public void setRetryTimes(int retryTimes) {
        this.retryTimes = retryTimes;
    }

    /**
     * Gets cycle retry times.
     *
     * @return the cycle retry times
     */
    public int getCycleRetryTimes() {
        return cycleRetryTimes;
    }

    /**
     * Sets cycle retry times.
     *
     * @param cycleRetryTimes the cycle retry times
     */
    public void setCycleRetryTimes(int cycleRetryTimes) {
        this.cycleRetryTimes = cycleRetryTimes;
    }

    /**
     * Gets retry sleep time.
     *
     * @return the retry sleep time
     */
    public int getRetrySleepTime() {
        return retrySleepTime;
    }

    /**
     * Sets retry sleep time.
     *
     * @param retrySleepTime the retry sleep time
     */
    public void setRetrySleepTime(int retrySleepTime) {
        this.retrySleepTime = retrySleepTime;
    }

    /**
     * Gets time out.
     *
     * @return the time out
     */
    public int getTimeOut() {
        return timeOut;
    }

    /**
     * Sets time out.
     *
     * @param timeOut the time out
     */
    public void setTimeOut(int timeOut) {
        this.timeOut = timeOut;
    }

    /**
     * Gets default status code set.
     *
     * @return the default status code set
     */
    public static Set<Integer> getDefaultStatusCodeSet() {
        return DEFAULT_STATUS_CODE_SET;
    }

    /**
     * Gets accept stat code.
     *
     * @return the accept stat code
     */
    public Set<Integer> getAcceptStatCode() {
        return acceptStatCode;
    }

    /**
     * Sets accept stat code.
     *
     * @param acceptStatCode the accept stat code
     */
    public void setAcceptStatCode(Set<Integer> acceptStatCode) {
        this.acceptStatCode = acceptStatCode;
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
     * Is use gzip boolean.
     *
     * @return the boolean
     */
    public boolean isUseGzip() {
        return useGzip;
    }

    /**
     * Sets use gzip.
     *
     * @param useGzip the use gzip
     */
    public void setUseGzip(boolean useGzip) {
        this.useGzip = useGzip;
    }

    /**
     * Is disable cookie management boolean.
     *
     * @return the boolean
     */
    public boolean isDisableCookieManagement() {
        return disableCookieManagement;
    }

    /**
     * Sets disable cookie management.
     *
     * @param disableCookieManagement the disable cookie management
     */
    public void setDisableCookieManagement(boolean disableCookieManagement) {
        this.disableCookieManagement = disableCookieManagement;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;

        Site site = (Site) o;

        if (cycleRetryTimes != site.cycleRetryTimes) return false;
        if (retryTimes != site.retryTimes) return false;
        if (sleepTime != site.sleepTime) return false;
        if (timeOut != site.timeOut) return false;
        if (acceptStatCode != null ? !acceptStatCode.equals(site.acceptStatCode) : site.acceptStatCode != null)
            return false;
        if (charset != null ? !charset.equals(site.charset) : site.charset != null) return false;
        if (defaultCookies != null ? !defaultCookies.equals(site.defaultCookies) : site.defaultCookies != null)
            return false;
        if (domain != null ? !domain.equals(site.domain) : site.domain != null) return false;
        if (headers != null ? !headers.equals(site.headers) : site.headers != null) return false;
        if (userAgent != null ? !userAgent.equals(site.userAgent) : site.userAgent != null) return false;

        return true;
    }

    @Override
    public int hashCode() {
        int result = domain != null ? domain.hashCode() : 0;
        result = 31 * result + (userAgent != null ? userAgent.hashCode() : 0);
        result = 31 * result + (defaultCookies != null ? defaultCookies.hashCode() : 0);
        result = 31 * result + (charset != null ? charset.hashCode() : 0);
        result = 31 * result + sleepTime;
        result = 31 * result + retryTimes;
        result = 31 * result + cycleRetryTimes;
        result = 31 * result + timeOut;
        result = 31 * result + (acceptStatCode != null ? acceptStatCode.hashCode() : 0);
        result = 31 * result + (headers != null ? headers.hashCode() : 0);
        return result;
    }

    @Override
    public String toString() {
        return "Site{" +
                "domain='" + domain + '\'' +
                ", userAgent='" + userAgent + '\'' +
                ", cookies=" + defaultCookies +
                ", charset='" + charset + '\'' +
                ", sleepTime=" + sleepTime +
                ", retryTimes=" + retryTimes +
                ", cycleRetryTimes=" + cycleRetryTimes +
                ", timeOut=" + timeOut +
                ", acceptStatCode=" + acceptStatCode +
                ", headers=" + headers +
                '}';
    }

}
