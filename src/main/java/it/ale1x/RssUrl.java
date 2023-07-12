package it.ale1x;

import org.w3c.dom.Document;

import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;
import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.net.MalformedURLException;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.Charset;
import org.w3c.dom.*;
import javax.xml.parsers.*;
import java.io.*;
import java.nio.charset.StandardCharsets;
import java.util.List;

public class RssUrl {

    public List<String> rssResponse;

    public static void scrap(String url) throws Exception {
        URLConnection connection = new URL(url).openConnection();

        connection.connect();

        BufferedReader response = new BufferedReader(new InputStreamReader(connection.getInputStream(),
                StandardCharsets.UTF_8));

        StringBuilder sb = new StringBuilder();
        String line;

        while((line = response.readLine()) != null) {
            sb.append(line);
        }

        DocumentBuilderFactory factory = DocumentBuilderFactory.newInstance();
        DocumentBuilder db = factory.newDocumentBuilder();
        Document doc = db.parse(sb.toString());

        Element e = doc.getDocumentElement();
        NodeList title = e.getElementsByTagName("title");

        System.out.println(title.toString());

    }

}
