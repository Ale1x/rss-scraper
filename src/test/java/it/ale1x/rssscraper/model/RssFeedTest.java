package it.ale1x.rssscraper.model;

import org.junit.jupiter.api.Test;
import java.time.OffsetDateTime;

import static org.junit.jupiter.api.Assertions.*;

public class RssFeedTest {

    @Test
    public void testGetAndSetElement() {
        RssFeed rssFeed = new RssFeed();
        rssFeed.setElement("title", "example");

        assertTrue(rssFeed.getElement("title").isPresent());
        assertEquals("example", rssFeed.getElement("title").get());
        assertFalse(rssFeed.getElement("nonexistent").isPresent());
    }

    @Test
    public void testGetAndSetPubDate() {
        RssFeed rssFeed = new RssFeed();
        OffsetDateTime dateTime = OffsetDateTime.now();
        rssFeed.setPubDate(dateTime);

        assertEquals(dateTime, rssFeed.getPubDate());
    }
}