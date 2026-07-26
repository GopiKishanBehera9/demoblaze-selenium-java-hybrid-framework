package com.demoblaze.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.demoblaze.constants.FrameworkConstants;
import com.demoblaze.exceptions.ConfigFileException;
import com.demoblaze.exceptions.PropertyNotFoundException;

/**
 * ConfigReader
 *
 * Reads configuration values from config.properties.
 *
 * @author Gopi Kishan Behera
 */
public final class ConfigReader {

    private static final Properties properties = new Properties();

    static {
        loadProperties();
    }

    private ConfigReader() {
        throw new IllegalStateException("Utility class");
    }

    private static void loadProperties() {

        System.out.println("========== ConfigReader ==========");
        System.out.println("Loading config file...");
        System.out.println("Path : " + FrameworkConstants.CONFIG_FILE_PATH);

        try (InputStream input = new FileInputStream(FrameworkConstants.CONFIG_FILE_PATH)) {

            properties.load(input);

            System.out.println("Config file loaded successfully.");
            System.out.println("Browser from file = " + properties.getProperty("browser"));

        } catch (IOException e) {

            System.err.println("Failed to load config file!");
            e.printStackTrace();

            throw new ConfigFileException(
                    "Unable to load config.properties file : "
                    + FrameworkConstants.CONFIG_FILE_PATH,
                    e);
        }
    }

    public static String getProperty(String key) {

        System.out.println("Reading property : " + key);

        String value = properties.getProperty(key);

        System.out.println("Value : " + value);

        if (value == null || value.trim().isEmpty()) {
        	throw new PropertyNotFoundException(
        	        "Property '" + key + "' not found in config.properties");
        }

        return value.trim();
    }

}