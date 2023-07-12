package it.ale1x.rssscraper.model;

import java.time.OffsetDateTime;

public class RssFeed {

    private String title;
    private String link;
    private String description;
    private String language;
    private OffsetDateTime pubDate;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getLink() {
        return link;
    }

    public void setLink(String link) {
        this.link = link;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public OffsetDateTime getPubDate() {
        return pubDate;
    }

    public void setPubDate(OffsetDateTime pubDate) {
        this.pubDate = pubDate;
    }
}
