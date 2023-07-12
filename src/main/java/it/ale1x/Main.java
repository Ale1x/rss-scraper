package it.ale1x;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileWriter;
import java.io.InputStreamReader;
import java.net.URL;
import java.net.URLConnection;
import java.nio.charset.StandardCharsets;
import javax.xml.parsers.DocumentBuilderFactory;
import javax.xml.parsers.DocumentBuilder;
import org.w3c.dom.Document;
import org.w3c.dom.NodeList;
import org.w3c.dom.Node;
import org.w3c.dom.Element;

public class Main {
    public static void main(String[] args) {

        try {
            String url = "https://www.ilsole24ore.com/rss/mondo--europa.xml";
            URLConnection connection = new URL(url).openConnection();

            connection.connect();

            BufferedReader response = new BufferedReader(new InputStreamReader(connection.getInputStream(),
                    StandardCharsets.UTF_8));

            StringBuilder sb = new StringBuilder();
            String line;

            File inputFile = new File("input.txt");
            FileWriter fw = null;
            try {
                fw = new FileWriter(inputFile);
            }catch(Exception e) {
                e.printStackTrace();
            }

            while((line = response.readLine()) != null) {
                sb.append(line);
                sb.append(System.lineSeparator());
                fw.write(line);
                fw.write("\n");
            }

            DocumentBuilderFactory dbFactory = DocumentBuilderFactory.newInstance();
            DocumentBuilder dBuilder = dbFactory.newDocumentBuilder();
            Document doc = dBuilder.parse(inputFile);
            doc.getDocumentElement().normalize();
            System.out.println("Root element :" + doc.getDocumentElement().getNodeName());
            NodeList nList = doc.getElementsByTagName("title");
            System.out.println("----------------------------");

            for (int temp = 0; temp < nList.getLength(); temp++) {
                Node nNode = nList.item(temp);
                System.out.println("\nCurrent Element :" + nNode.getNodeName());
            }
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
