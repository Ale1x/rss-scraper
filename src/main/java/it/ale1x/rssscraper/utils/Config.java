package it.ale1x.rssscraper.utils;

import org.yaml.snakeyaml.Yaml;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Config {

    private final File file;
    private final Yaml yamlReader;

    private final Map<String, Object> data;

    public Config(String path) {
        validatePath(path);
        file = new File(path);
        yamlReader = new Yaml();
        data = readData();
    }

    public String getString(String key) {
        return getValue(key, String.class, "");
    }

    public int getInt(String key) {
        return getValue(key, Integer.class, 0);
    }

    public boolean getBoolean(String key) {
        return getValue(key, Boolean.class, false);
    }

    public float getFloat(String key) {
        return getValue(key, Float.class, 0f);
    }

    private <T> T getValue(String key, Class<T> valueType, T defaultValue) {
        if (data.containsKey(key)) {
            Object value = data.get(key);
            if (valueType.isInstance(value)) {
                return valueType.cast(value);
            }
        }
        return defaultValue;
    }

    private Map<String, Object> readData() {
        try (InputStream inputStream = new FileInputStream(file)) {
            if (file.exists() && file.isFile()) {
                return yamlReader.load(inputStream);
            }
        } catch (IOException e) {
            throw new RuntimeException("Errore durante la lettura del file di configurazione.", e);
        }
        return new HashMap<>();
    }

    private void validatePath(String path) {
        if (path == null || path.isEmpty()) {
            throw new IllegalArgumentException("Il percorso del file di configurazione non può essere nullo o vuoto.");
        }
    }

}