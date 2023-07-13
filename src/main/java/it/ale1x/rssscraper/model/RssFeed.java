package it.ale1x.rssscraper.model;

import java.time.OffsetDateTime;

public class RssFeed {

    private String title;
    private String link;
    private String description;
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

    public void printInfo() {
        if(title == null || title.isEmpty()) return;
        if(link == null || link.isEmpty()) return;
        if(description == null || description.isEmpty()) return;
        if(pubDate == null) return;

        System.out.println("Titolo: " + title);
        System.out.println("Descrizione: " + description);
        System.out.println("Data di pubblicazione: " + pubDate.toString());
        System.out.println("Link: " + link + "\n");
    }
}
