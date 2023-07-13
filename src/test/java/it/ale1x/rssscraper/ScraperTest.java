package it.ale1x.rssscraper;

import it.ale1x.rssscraper.service.RssScraper;
import it.ale1x.rssscraper.model.RssFeed;

import static org.junit.Assert.*;
import org.junit.Test;

import java.util.List;
import java.util.Optional;

public class ScraperTest {

    private final RssScraper rssScraper = new RssScraper("https://www.ansa.it/sito/notizie/sport/calcio/calcio_rss.xml");
    List<RssFeed> rssFeedList = rssScraper.scrape();
    @Test
    public void testScrap_title_notNull() {

        for(RssFeed feed : rssFeedList) {
            assertNotEquals(feed.getElement("title"), Optional.empty());
        }
    }

    @Test
    public void testScrap_description_notNull() {

        for(RssFeed feed : rssFeedList) {
            assertNotEquals(feed.getElement("description"), Optional.empty());
        }
    }

    @Test
    public void testScrap_link_notNull() {

        for(RssFeed feed : rssFeedList) {
            assertNotEquals(feed.getElement("link"), Optional.empty());
        }
    }

    @Test
    public void testScrap_date_notNull() {

        for(RssFeed feed : rssFeedList) {
            assertNotEquals(feed.getPubDate(), null);
        }
    }

    @Test
    public void testThat_AddElementWithKeyAlreadyExist_succesfullyReplaced() {

        rssFeedList.get(0).setElement("title", "ciao");

        assertEquals(rssFeedList.get(0).getElement("title").get(), "ciao");


        for(RssFeed feed : rssFeedList) {
            assertNotEquals(feed.getPubDate(), null);
        }
    }


}
