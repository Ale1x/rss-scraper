package it.ale1x.rssscraper.model;

import java.time.OffsetDateTime;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;

public class RssFeed {

    private final Map<String, String> elements = new HashMap<>();

    private OffsetDateTime pubDate;

    public Optional<String> getElement(String key) {
        return Optional.ofNullable(elements.get(key));
    }

    public void setElement(String key, String value) {
        elements.put(key, value);
    }

    public OffsetDateTime getPubDate() {
        return pubDate;
    }

    public void setPubDate(OffsetDateTime pubDate) {
        this.pubDate = pubDate;
    }

    public void printInfo() {
        for (Map.Entry<String, String> entry : elements.entrySet()) {
            System.out.println(entry.getKey() + ": " + entry.getValue());
        }
        System.out.println();
    }
}
