package tk.clawhub.downloader;

import org.apache.commons.io.IOUtils;
import org.apache.http.HttpResponse;
import org.apache.http.client.HttpClient;
import org.apache.http.util.EntityUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.clawhub.model.Page;
import tk.clawhub.model.Request;
import tk.clawhub.model.Task;
import tk.clawhub.proxy.Proxy;
import tk.clawhub.proxy.SimpleProxyProvider;
import tk.clawhub.util.CharsetUtils;
import tk.clawhub.util.HttpUtil;
import tk.clawhub.util.http.HttpClientGenerator;
import tk.clawhub.util.http.HttpClientRequestContext;
import tk.clawhub.util.http.HttpUriRequestConverter;

import java.io.IOException;
import java.nio.charset.Charset;

/**
 * <Description>Simple downloader <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @date 2018 -07-24 <br>
 */
@Component
public class SimpleDownloader implements Idownloader {
    /**
     * The Logger.
     */
    private Logger logger = LoggerFactory.getLogger(getClass());
    /**
     * The Http client generator.
     */
    @Autowired
    private HttpClientGenerator httpClientGenerator;
    /**
     * The Http uri request converter.
     */
    @Autowired
    private HttpUriRequestConverter httpUriRequestConverter;
    /**
     * The Proxy provider.
     */
    @Autowired
    private SimpleProxyProvider proxyProvider;
    /**
     * The Response header.
     */
    private boolean responseHeader = true;

    @Override
    public void setThread(int thread) {
        httpClientGenerator.setPoolSize(thread);
    }

    @Override
    public Page download(Request request, Task task) {
        if (task == null || task.getSite() == null) {
            throw new NullPointerException("task or site can not be null");
        }
        //获取HttpClient
        HttpClient httpClient = httpClientGenerator.generateClient(task.getSite());
        Proxy proxy = proxyProvider != null ? proxyProvider.getProxy(task) : null;
        HttpClientRequestContext requestContext = httpUriRequestConverter.convert(request, task.getSite(), proxy);
        Page page = Page.fail();
        HttpResponse httpResponse = null;
        try {

            httpResponse = httpClient.execute(requestContext.getHttpUriRequest(), requestContext.getHttpClientContext());
            page = handleResponse(request, request.getCharset() != null ? request.getCharset() : task.getSite().getCharset(), httpResponse);
            logger.info("downloading page success {}", request.getUrl());
            return page;
        } catch (IOException e) {
            logger.warn("download page {} error", request.getUrl(), e);
            return page;
        } finally {
            if (httpResponse != null) {
                //ensure the connection is released back to pool
                EntityUtils.consumeQuietly(httpResponse.getEntity());
            }
            if (proxyProvider != null && proxy != null) {
                proxyProvider.returnProxy(proxy, page, task);
            }
        }
    }

    /**
     * Handle response page.
     *
     * @param request      the request
     * @param charset      the charset
     * @param httpResponse the http response
     * @return the page
     * @throws IOException the io exception
     */
    protected Page handleResponse(Request request, String charset, HttpResponse httpResponse) throws IOException {
        byte[] bytes = IOUtils.toByteArray(httpResponse.getEntity().getContent());
        String contentType = httpResponse.getEntity().getContentType() == null ? "" : httpResponse.getEntity().getContentType().getValue();
        Page page = new Page();
        page.setBytes(bytes);
        if (!request.isBinaryContent()) {
            if (charset == null) {
                charset = getHtmlCharset(contentType, bytes);
            }
            page.setCharset(charset);
            page.setRawText(new String(bytes, charset));
        }
        page.setRequest(request);
        page.setStatusCode(httpResponse.getStatusLine().getStatusCode());
        page.setDownloadSuccess(true);
        if (responseHeader) {
            page.setHeaders(HttpUtil.convertHeaders(httpResponse.getAllHeaders()));
        }
        return page;
    }

    /**
     * Gets html charset.
     *
     * @param contentType  the content type
     * @param contentBytes the content bytes
     * @return the html charset
     * @throws IOException the io exception
     */
    private String getHtmlCharset(String contentType, byte[] contentBytes) throws IOException {
        String charset = CharsetUtils.detectCharset(contentType, contentBytes);
        if (charset == null) {
            charset = Charset.defaultCharset().name();
            logger.warn("Charset autodetect failed, use {} as charset. Please specify charset in Site.setCharset()", Charset.defaultCharset());
        }
        return charset;
    }
}
