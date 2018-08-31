package tk.clawhub.url;

/**
 * <Description>Url <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @date 2018 -07-25 <br>
 */
public class Url {
    /**
     * The Url.
     */
    private String url;
    /**
     * The Weight.
     */
    private int weight;

    /**
     * Instantiates a new Url.
     *
     * @param url    the url
     * @param weight the weight
     */
    public Url(String url, int weight) {
        this.url = url;
        this.weight = weight;
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
     * Gets weight.
     *
     * @return the weight
     */
    public int getWeight() {
        return weight;
    }

    /**
     * Sets weight.
     *
     * @param weight the weight
     */
    public void setWeight(int weight) {
        this.weight = weight;
    }

    @Override
    public String toString() {
        return "Url{" +
                "url='" + url + '\'' +
                ", weight=" + weight +
                '}';
    }
}
