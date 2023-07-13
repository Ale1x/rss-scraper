package it.ale1x.rssscraper;

import it.ale1x.rssscraper.service.RssScraper;
import it.ale1x.rssscraper.model.RssFeed;
import it.ale1x.rssscraper.util.RssConfig;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) {

        RssConfig config = new RssConfig("config.yml");
        List<String> urls = config.getUrlsFromConfig();

        List<RssScraper> scrapers = urls.stream()
                .map(RssScraper::new)
                .toList();

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (RssScraper scraper : scrapers) {
            executor.submit(() -> scraper.scrape().forEach(RssFeed::printInfo));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {}

    }
}