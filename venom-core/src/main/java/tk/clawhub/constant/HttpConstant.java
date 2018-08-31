package tk.clawhub.constant;

/**
 * <Description>Http constant <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @date 2018 -07-24 <br>
 */
public abstract class HttpConstant {

    /**
     * <Description>Method <br>
     *
     * @author LiZhiming<br>
     * @version 1.0<br>
     * @taskId <br>
     * @date 2018 -07-24 <br>
     */
    public static abstract class Method {

        /**
         * The constant GET.
         */
        public static final String GET = "GET";

        /**
         * The constant HEAD.
         */
        public static final String HEAD = "HEAD";

        /**
         * The constant POST.
         */
        public static final String POST = "POST";

        /**
         * The constant PUT.
         */
        public static final String PUT = "PUT";

        /**
         * The constant DELETE.
         */
        public static final String DELETE = "DELETE";

        /**
         * The constant TRACE.
         */
        public static final String TRACE = "TRACE";

        /**
         * The constant CONNECT.
         */
        public static final String CONNECT = "CONNECT";

    }

    /**
     * <Description>Status code <br>
     *
     * @author LiZhiming<br>
     * @version 1.0<br>
     * @taskId <br>
     * @date 2018 -07-24 <br>
     */
    public static abstract class StatusCode {

        /**
         * The constant CODE_200.
         */
        public static final int CODE_200 = 200;

    }

    /**
     * <Description>Header <br>
     *
     * @author LiZhiming<br>
     * @version 1.0<br>
     * @taskId <br>
     * @date 2018 -07-24 <br>
     */
    public static abstract class Header {

        /**
         * The constant REFERER.
         */
        public static final String REFERER = "Referer";

        /**
         * The constant USER_AGENT.
         */
        public static final String USER_AGENT = "User-Agent";
    }

}