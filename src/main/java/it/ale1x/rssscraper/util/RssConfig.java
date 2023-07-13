package it.ale1x.rssscraper.util;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.io.IOException;
public class RssConfig {


    public static List<String> getElementsFromConfig(String filepath) {
        Yaml yaml = new Yaml();

        try (InputStream in = Files.newInputStream(Paths.get(filepath))) {
            Map<String, List<String>> yamlMap = yaml.load(in);

            return yamlMap.get("element");
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the config file", e);
        }
    }
}
