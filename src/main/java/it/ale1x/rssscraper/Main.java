package it.ale1x.rssscraper;

import it.ale1x.rssscraper.service.RssScraper;

import java.io.File;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Main {
    public static void main(String[] args) throws Exception {

        File file = new File("input.txt");

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
            executor.submit(() -> scraper.scrape().forEach(scraper::printInfo));
        }

        executor.shutdown();
        while (!executor.isTerminated()) {}

        scanner.close();
    }
}