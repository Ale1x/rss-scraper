package it.ale1x.rssscraper.service;

import it.ale1x.rssscraper.model.RssFeed;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.junit.jupiter.api.Test;
import org.mockito.Mockito;

import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.Mockito.*;

public class RssScraperTest {

    @Test
    public void testScrape() {
        RssScraper rssScraper = new RssScraper("https://www.ansa.it/sito/ansait_rss.xml");
        Document doc = Jsoup.parse("<rss><channel><item><title>Test</title><pubDate>Tue, 30 May 2023 22:06:53 +0200</pubDate></item></channel></rss>");

        RssScraper spyRssScraper = Mockito.spy(rssScraper);
        doReturn(doc).when(spyRssScraper).connect();

        List<RssFeed> rssFeeds = spyRssScraper.scrape();

        assertEquals(4, rssFeeds.size());
        assertEquals("Test", rssFeeds.get(0).getElement("title").orElse(""));

        // Verify that the connect method was called only once
        verify(spyRssScraper, times(1)).connect();
    }
}
