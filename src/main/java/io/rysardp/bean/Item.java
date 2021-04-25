package io.rysardp.bean;

import java.util.Objects;

public class Item {

    private String watchTitle;
    private String watchPrice;
    private String watchLink;

    public Item(String watchTitle, String watchPrice, String watchLink) {
        this.watchTitle = watchTitle;
        this.watchPrice = watchPrice;
        this.watchLink = watchLink;
    }

    public String getWatchTitle() {
        return watchTitle;
    }

    public void setWatchTitle(String watchTitle) {
        this.watchTitle = watchTitle;
    }

    public String getWatchPrice() {
        return watchPrice;
    }

    public void setWatchPrice(String watchPrice) {
        this.watchPrice = watchPrice;
    }

    public String getWatchLink() {
        return watchLink;
    }

    public void setWatchLink(String watchLink) {
        this.watchLink = watchLink;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Item item = (Item) o;
        return Objects.equals(watchTitle, item.watchTitle) &&
                Objects.equals(watchPrice, item.watchPrice) &&
                Objects.equals(watchLink, item.watchLink);
    }

    @Override
    public int hashCode() {
        return Objects.hash(watchTitle, watchPrice, watchLink);
    }

    @Override
    public String
    toString() {
        return "Item{" +
                "watchTitle='" + watchTitle + '\'' +
                ", watchPrice='" + watchPrice + '\'' +
                ", watchLink='" + watchLink + '\'' +
                '}';
    }
}
