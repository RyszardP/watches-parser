package io.rysardp;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URL;

public class Parser {

    private static Document getPage() throws IOException {
        String url = "https://www.houseofwatches.co.uk/mens-watches/";
        Document page = Jsoup.parse(new URL(url), 5000);
        return page;
    }

    public static void main(String[] args) throws Exception {
        Document page = getPage();
        Element tableCont = page.select("#amshopby-page-container > div.category-products > ul > div").first(); // find table
        Elements itemCells = tableCont.select("li");
        FileWriter csvWriter = new FileWriter("src/main/resources/new.csv");
        csvWriter.append("Title");
        csvWriter.append(",");
        csvWriter.append("Price");
        csvWriter.append(",");
        csvWriter.append("link");
        csvWriter.append("\n");

        for (Element element : itemCells) {
            String watchTitle = element.select("div > div.product-info > h2").text();
            String watchPrice = element.select("div > div.product-info > div.price-box > span.special-price").text();
            String watchLink = element.select("div > div.product-info > h2 > a").attr("href");
            csvWriter.append(watchTitle);
            csvWriter.append(",");
            csvWriter.append(watchPrice);
            csvWriter.append(",");
            csvWriter.append(watchLink);
            csvWriter.append("\n");
        }
        csvWriter.flush();
        csvWriter.close();
    }

}
