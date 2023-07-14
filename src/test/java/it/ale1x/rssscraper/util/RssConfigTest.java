package it.ale1x.rssscraper.util;

import org.junit.jupiter.api.Test;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

public class RssConfigTest {

    @Test
    public void testGetElementsFromConfig() {
        RssConfig rssConfig = new RssConfig("config.yml");

        String url = "https://www.ansa.it/sito/ansait_rss.xml";

        assertTrue(rssConfig.getUrlsFromConfig().contains(url));
    }

    @Test
    public void testGetUrlsFromConfig() {
        RssConfig rssConfig = new RssConfig("config.yml");
        assertEquals(List.of("title", "description", "link", "pubDate"), rssConfig.getElementsFromConfig());
    }
}
