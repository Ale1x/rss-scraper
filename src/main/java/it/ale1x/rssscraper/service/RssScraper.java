package it.ale1x.rssscraper.service;

import it.ale1x.rssscraper.model.RssFeed;
import it.ale1x.rssscraper.util.RssConfig;
import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.IOException;
import java.time.OffsetDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;


public class RssScraper {

    private final String url;
    private final List<String> elements;

    public RssScraper(String url) {
        this.url = url;
        RssConfig config = new RssConfig("config.yml");
        elements = config.getElementsFromConfig();
    }

    public List<RssFeed> scrape() {
        List<RssFeed> rssFeeds = new ArrayList<>();

        Document doc;
        try {
            doc = Jsoup.connect(url).get();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        Elements items = doc.select("item");

        for(Element item : items) {
            RssFeed feed = new RssFeed();

            for(String s : elements) {
                feed.setElement(s, item.select(s).text());
                feed.setPubDate(OffsetDateTime.parse(item.select("pubDate").text(),
                        DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH)));
                rssFeeds.add(feed);
            }
        }

        return rssFeeds;
    }


}
