package it.ale1x.rssscraper;

import it.ale1x.rssscraper.service.RssScraper;
import it.ale1x.rssscraper.model.RssFeed;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;

public class ScraperTest {

    @Test
    public void testScrap_title_notNull() {
        RssScraper rssScraper = new RssScraper("https://www.ansa.it/sito/notizie/sport/calcio/calcio_rss.xml");
        List<RssFeed> rssFeedList = rssScraper.scrape();

        for(RssFeed feed : rssFeedList) {
            assertNotEquals(feed.getTitle(), "");
        }
    }

    @Test
    public void testScrap_description_notNull() {
        RssScraper rssScraper = new RssScraper("https://www.ansa.it/sito/notizie/sport/calcio/calcio_rss.xml");
        List<RssFeed> rssFeedList = rssScraper.scrape();

        for(RssFeed feed : rssFeedList) {
            assertNotEquals(feed.getDescription(), "");
        }
    }

    @Test
    public void testScrap_link_notNull() {
        RssScraper rssScraper = new RssScraper("https://www.ansa.it/sito/notizie/sport/calcio/calcio_rss.xml");
        List<RssFeed> rssFeedList = rssScraper.scrape();

        for(RssFeed feed : rssFeedList) {
            assertNotEquals(feed.getLink(), "");
        }
    }

    @Test
    public void testScrap_date_notNull() {
        RssScraper rssScraper = new RssScraper("https://www.ansa.it/sito/notizie/sport/calcio/calcio_rss.xml");
        List<RssFeed> rssFeedList = rssScraper.scrape();

        for(RssFeed feed : rssFeedList) {
            assertNotEquals(feed.getPubDate(), null);
        }
    }


}