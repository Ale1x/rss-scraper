package it.ale1x;

import it.ale1x.rssscraper.model.RssFeed;
import it.ale1x.rssscraper.service.RssScraper;

import java.io.IOException;

public class Main {
    public static void main(String[] args) throws IOException {

        RssScraper rss = new RssScraper("https://www.ansa.it/sito/notizie/mondo/mondo_rss.xml");

        for(RssFeed feed : rss.scrape()) {
            System.out.println("Titolo: " + feed.getTitle());
            System.out.println("Descrizione: " + feed.getDescription());
            System.out.println("Data di pubblicazione: " + feed.getPubDate().toString());
            System.out.println("Link: " + feed.getLink() + "\n");

        }
    }
}
