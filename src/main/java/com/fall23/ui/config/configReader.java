package com.fall23.ui.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

public class configReader {

    private static Properties properties;

    private configReader() {
    // Singleton
    }

    static {
        try {
            String path = "src/main/resources/application.properties";
            FileInputStream inputStream = new FileInputStream(path);
            properties = new Properties();
            properties.load(inputStream);
            inputStream.close();
        } catch (IOException e){
            throw new RuntimeException(e);
        }
    }

    public static String getValue(String key){
        return properties.getProperty(key).trim();
    }
}
