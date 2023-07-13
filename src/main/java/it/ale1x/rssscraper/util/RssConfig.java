package it.ale1x.rssscraper.util;

import org.yaml.snakeyaml.Yaml;

import java.io.InputStream;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.util.List;
import java.util.Map;
import java.io.IOException;
public class RssConfig {

    private final String filepath;

    public RssConfig(String filepath) {
        this.filepath = filepath;
    }

    public List<String> getElementsFromConfig() {
        Yaml yaml = new Yaml();

        try (InputStream in = Files.newInputStream(Paths.get(filepath))) {
            Map<String, List<String>> yamlMap = yaml.load(in);

            return yamlMap.get("element");
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the config file", e);
        }
    }

    public List<String> getUrlsFromConfig() {

        Yaml yaml = new Yaml();

        try (InputStream in = Files.newInputStream(Paths.get(filepath))) {
            Map<String, List<String>> yamlMap = yaml.load(in);

            return yamlMap.get("urls");
        } catch (IOException e) {
            throw new RuntimeException("Failed to read the config file", e);
        }

    }
}
