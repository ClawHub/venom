package tk.clawhub.service;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import tk.clawhub.downloader.SimpleDownloader;
import tk.clawhub.model.Page;
import tk.clawhub.model.Request;
import tk.clawhub.model.Site;
import tk.clawhub.model.Task;

import java.util.List;
import java.util.UUID;

/**
 * <Description>Xici url <br>
 *
 * @author LiZhiming<br>
 * @version 1.0<br>
 * @taskId <br>
 * @date 2018 -07-26 <br>
 */
@Component
public class XiciUrl implements IUrl {

    /**
     * The Simple downloader.
     */
    @Autowired
    private SimpleDownloader simpleDownloader;

    @Override
    public void execute() {
        //下载种子URL页面
        String seed = "http://www.xicidaili.com/nn/";
        Request request = new Request();
        request.setUrl(seed);
        Task task = new Task() {
            @Override
            public String getUUID() {
                return UUID.randomUUID().toString();
            }

            @Override
            public Site getSite() {
                return new Site();
            }
        };
        Page page = simpleDownloader.download(request, task);
        //解析page 获取低级URL
        String rawText = page.getRawText();
        Document document = Jsoup.parse(rawText);
        Element element = document.body();
        Elements elements = element.getElementsByClass("pagination");
        Elements a = elements.last().getElementsByAttributeValueContaining("href", "/nn").removeClass("next_page");
        List<String> list = a.eachText();
        //最后一页
        int end = Integer.parseInt(list.get(list.size() - 2));
        System.out.println(end);
        //低级url入redis
        for (int i = 2; i <= end; i++) {
            System.out.println(seed + i);
        }
    }

    @Override
    public String getCron() {
        return null;
    }
}
