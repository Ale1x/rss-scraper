package it.ale1x.rssscraper.service;

import it.ale1x.rssscraper.model.RssFeed;
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

    public RssScraper(String url) {
        this.url = url;
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
            feed.setTitle(item.select("title").text());
            feed.setDescription(item.select("description").text());
            feed.setLink(item.select("link").text());
            feed.setPubDate(OffsetDateTime.parse(item.select("pubDate").text(),
                    DateTimeFormatter.ofPattern("EEE, dd MMM yyyy HH:mm:ss Z", Locale.ENGLISH)));
            rssFeeds.add(feed);
        }

        return rssFeeds;
    }

    public void printInfo(RssFeed feed) {
        if(feed == null) return;

        System.out.println("Titolo: " + feed.getTitle());
        System.out.println("Descrizione: " + feed.getDescription());
        System.out.println("Data di pubblicazione: " + feed.getPubDate().toString());
        System.out.println("Link: " + feed.getLink() + "\n");
    }

}
