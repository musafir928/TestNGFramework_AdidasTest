package com.adidas.utilities;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

public class ConfigurationReader {
    private static Properties properties;
    static {
        try{
            //what file is to read
            String path = "configuration.properties";
            // read the file into java, find the file using the string path
            FileInputStream input = new FileInputStream(path);
            // properties --> class that store properties in key -- value pair
            properties = new Properties();
            // put the data into properties object
            properties.load(input);
            input.close();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static String get(String keyName) {
        return properties.getProperty(keyName);
    }
}
