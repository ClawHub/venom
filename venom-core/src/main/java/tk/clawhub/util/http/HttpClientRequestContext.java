package tk.clawhub.util.http;

import org.apache.http.client.methods.HttpUriRequest;
import org.apache.http.client.protocol.HttpClientContext;

/**
 * <Description>Http client request context <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @date 2018 -07-24 <br>
 */
public class HttpClientRequestContext {

    /**
     * The Http uri request.
     */
    private HttpUriRequest httpUriRequest;

    /**
     * The Http client context.
     */
    private HttpClientContext httpClientContext;

    /**
     * Gets http uri request.
     *
     * @return the http uri request
     */
    public HttpUriRequest getHttpUriRequest() {
        return httpUriRequest;
    }

    /**
     * Sets http uri request.
     *
     * @param httpUriRequest the http uri request
     */
    public void setHttpUriRequest(HttpUriRequest httpUriRequest) {
        this.httpUriRequest = httpUriRequest;
    }

    /**
     * Gets http client context.
     *
     * @return the http client context
     */
    public HttpClientContext getHttpClientContext() {
        return httpClientContext;
    }

    /**
     * Sets http client context.
     *
     * @param httpClientContext the http client context
     */
    public void setHttpClientContext(HttpClientContext httpClientContext) {
        this.httpClientContext = httpClientContext;
    }

}
