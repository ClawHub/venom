package tk.clawhub.model;

import tk.clawhub.constant.HttpConstant;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Map;

/**
 * <Description>Page <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @date 2018 -07-24 <br>
 */
public class Page {

    /**
     * The Request.
     */
    private Request request;


    /**
     * The Raw text.
     */
    private String rawText;


    /**
     * The Headers.
     */
    private Map<String, List<String>> headers;

    /**
     * The Status code.
     */
    private int statusCode = HttpConstant.StatusCode.CODE_200;

    /**
     * The Download success.
     */
    private boolean downloadSuccess = true;

    /**
     * The Bytes.
     */
    private byte[] bytes;

    /**
     * The Target requests.
     */
    private List<Request> targetRequests = new ArrayList<Request>();

    /**
     * The Charset.
     */
    private String charset;

    /**
     * Instantiates a new Page.
     */
    public Page() {
    }

    /**
     * Fail page.
     *
     * @return the page
     */
    public static Page fail() {
        Page page = new Page();
        page.setDownloadSuccess(false);
        return page;
    }

    /**
     * Gets request.
     *
     * @return the request
     */
    public Request getRequest() {
        return request;
    }

    /**
     * Sets request.
     *
     * @param request the request
     */
    public void setRequest(Request request) {
        this.request = request;
    }

    /**
     * Gets raw text.
     *
     * @return the raw text
     */
    public String getRawText() {
        return rawText;
    }

    /**
     * Sets raw text.
     *
     * @param rawText the raw text
     */
    public void setRawText(String rawText) {
        this.rawText = rawText;
    }

    /**
     * Gets headers.
     *
     * @return the headers
     */
    public Map<String, List<String>> getHeaders() {
        return headers;
    }

    /**
     * Sets headers.
     *
     * @param headers the headers
     */
    public void setHeaders(Map<String, List<String>> headers) {
        this.headers = headers;
    }

    /**
     * Gets status code.
     *
     * @return the status code
     */
    public int getStatusCode() {
        return statusCode;
    }

    /**
     * Sets status code.
     *
     * @param statusCode the status code
     */
    public void setStatusCode(int statusCode) {
        this.statusCode = statusCode;
    }

    /**
     * Is download success boolean.
     *
     * @return the boolean
     */
    public boolean isDownloadSuccess() {
        return downloadSuccess;
    }

    /**
     * Sets download success.
     *
     * @param downloadSuccess the download success
     */
    public void setDownloadSuccess(boolean downloadSuccess) {
        this.downloadSuccess = downloadSuccess;
    }

    /**
     * Get bytes byte [ ].
     *
     * @return the byte [ ]
     */
    public byte[] getBytes() {
        return bytes;
    }

    /**
     * Sets bytes.
     *
     * @param bytes the bytes
     */
    public void setBytes(byte[] bytes) {
        this.bytes = bytes;
    }

    /**
     * Gets target requests.
     *
     * @return the target requests
     */
    public List<Request> getTargetRequests() {
        return targetRequests;
    }

    /**
     * Sets target requests.
     *
     * @param targetRequests the target requests
     */
    public void setTargetRequests(List<Request> targetRequests) {
        this.targetRequests = targetRequests;
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

    @Override
    public String toString() {
        return "Page{" +
                "request=" + request +
                ", rawText='" + rawText + '\'' +
                ", headers=" + headers +
                ", statusCode=" + statusCode +
                ", downloadSuccess=" + downloadSuccess +
                ", bytes=" + Arrays.toString(bytes) +
                ", targetRequests=" + targetRequests +
                ", charset='" + charset + '\'' +
                '}';
    }
}
