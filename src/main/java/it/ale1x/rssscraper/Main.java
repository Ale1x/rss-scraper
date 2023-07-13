package it.ale1x.rssscraper;

import it.ale1x.rssscraper.service.RssScraper;
import it.ale1x.rssscraper.model.RssFeed;
import it.ale1x.rssscraper.util.RssConfig;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws Exception {

        // String fileName = args[0];
        File file = new File(RssConfig.getInputFilenameFromConfig("config.yml"));
        Scanner scanner = new Scanner(file);

        List<String> urls = new ArrayList<>();

        while (scanner.hasNextLine()) {
            urls.add(scanner.nextLine());
        }

        List<RssScraper> scrapers = urls.stream()
                .map(RssScraper::new)
                .toList();

        ExecutorService executor = Executors.newFixedThreadPool(10);

        for (RssScraper scraper : scrapers) {
            executor.submit(() -> scraper.scrape().forEach(RssFeed::printInfo));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {}

        scanner.close();
    }
}