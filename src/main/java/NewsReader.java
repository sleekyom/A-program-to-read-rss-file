import com.rometools.rome.feed.synd.SyndEntry;
import com.rometools.rome.feed.synd.SyndFeed;
import com.rometools.rome.io.SyndFeedInput;
import com.rometools.rome.io.XmlReader;

import java.net.URL;

public class NewsReader {
    public static void main(String[] args) {
        NewsReader newsReader = new NewsReader();
        newsReader.rss();
    }

    public void rss() {
        try {
            String rssUrl = "https://www.aljazeera.com/xml/rss/all.xml";
            XmlReader xmlReader = new XmlReader(new URL(rssUrl));
            SyndFeed syndFeed = new SyndFeedInput().build(xmlReader);


            for (SyndEntry syndEntry : syndFeed.getEntries()) {
                System.out.println("Title of news : " + syndEntry.getTitle());
                System.out.println("Published date of news : " + syndEntry.getPublishedDate());
                System.out.println();
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
