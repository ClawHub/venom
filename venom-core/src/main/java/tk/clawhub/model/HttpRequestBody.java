package tk.clawhub.model;

import org.apache.http.NameValuePair;
import org.apache.http.client.utils.URLEncodedUtils;
import org.apache.http.message.BasicNameValuePair;

import java.io.Serializable;
import java.io.UnsupportedEncodingException;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

/**
 * <Description>Http request body <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @date 2018 -07-24 <br>
 */
public class HttpRequestBody implements Serializable {

    /**
     * The constant serialVersionUID.
     */
    private static final long serialVersionUID = 5659170945717023595L;

    /**
     * <Description>Content type <br>
     *
     * @author LiZhiming<br>
     * @version 1.0<br>
     * @taskId <br>
     * @date 2018 -07-24 <br>
     */
    public static abstract class ContentType {

        /**
         * The constant JSON.
         */
        public static final String JSON = "application/json";

        /**
         * The constant XML.
         */
        public static final String XML = "text/xml";

        /**
         * The constant FORM.
         */
        public static final String FORM = "application/x-www-form-urlencoded";

        /**
         * The constant MULTIPART.
         */
        public static final String MULTIPART = "multipart/form-data";
    }

    /**
     * The Body.
     */
    private byte[] body;

    /**
     * The Content type.
     */
    private String contentType;

    /**
     * The Encoding.
     */
    private String encoding;

    /**
     * Instantiates a new Http request body.
     */
    public HttpRequestBody() {
    }

    /**
     * Instantiates a new Http request body.
     *
     * @param body        the body
     * @param contentType the content type
     * @param encoding    the encoding
     */
    public HttpRequestBody(byte[] body, String contentType, String encoding) {
        this.body = body;
        this.contentType = contentType;
        this.encoding = encoding;
    }

    /**
     * Gets content type.
     *
     * @return the content type
     */
    public String getContentType() {
        return contentType;
    }

    /**
     * Gets encoding.
     *
     * @return the encoding
     */
    public String getEncoding() {
        return encoding;
    }

    /**
     * Sets body.
     *
     * @param body the body
     */
    public void setBody(byte[] body) {
        this.body = body;
    }

    /**
     * Sets content type.
     *
     * @param contentType the content type
     */
    public void setContentType(String contentType) {
        this.contentType = contentType;
    }

    /**
     * Sets encoding.
     *
     * @param encoding the encoding
     */
    public void setEncoding(String encoding) {
        this.encoding = encoding;
    }

    /**
     * Json http request body.
     *
     * @param json     the json
     * @param encoding the encoding
     * @return the http request body
     */
    public static HttpRequestBody json(String json, String encoding) {
        try {
            return new HttpRequestBody(json.getBytes(encoding), ContentType.JSON, encoding);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("illegal encoding " + encoding, e);
        }
    }

    /**
     * Xml http request body.
     *
     * @param xml      the xml
     * @param encoding the encoding
     * @return the http request body
     */
    public static HttpRequestBody xml(String xml, String encoding) {
        try {
            return new HttpRequestBody(xml.getBytes(encoding), ContentType.XML, encoding);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("illegal encoding " + encoding, e);
        }
    }

    /**
     * Custom http request body.
     *
     * @param body        the body
     * @param contentType the content type
     * @param encoding    the encoding
     * @return the http request body
     */
    public static HttpRequestBody custom(byte[] body, String contentType, String encoding) {
        return new HttpRequestBody(body, contentType, encoding);
    }

    /**
     * Form http request body.
     *
     * @param params   the params
     * @param encoding the encoding
     * @return the http request body
     */
    public static HttpRequestBody form(Map<String, Object> params, String encoding) {
        List<NameValuePair> nameValuePairs = new ArrayList<>(params.size());
        for (Map.Entry<String, Object> entry : params.entrySet()) {
            nameValuePairs.add(new BasicNameValuePair(entry.getKey(), String.valueOf(entry.getValue())));
        }
        try {
            return new HttpRequestBody(URLEncodedUtils.format(nameValuePairs, encoding).getBytes(encoding), ContentType.FORM, encoding);
        } catch (UnsupportedEncodingException e) {
            throw new IllegalArgumentException("illegal encoding " + encoding, e);
        }
    }

    /**
     * Get body byte [ ].
     *
     * @return the byte [ ]
     */
    public byte[] getBody() {
        return body;
    }
}
