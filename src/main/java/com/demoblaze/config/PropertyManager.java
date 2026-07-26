package com.demoblaze.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.demoblaze.constants.FrameworkConstants;
import com.demoblaze.exceptions.ConfigFileException;
import com.demoblaze.exceptions.PropertyNotFoundException;

public final class PropertyManager {

    private static final Properties environmentProperties = new Properties();

    static {
        loadEnvironmentProperties();
    }

    private PropertyManager() {
        throw new IllegalStateException("Utility class");
    }

    private static void loadEnvironmentProperties() {

        String environment = ConfigReader.getProperty("environment").toLowerCase();

        String filePath;

        switch (environment) {

        case "qa":
            filePath = FrameworkConstants.QA_CONFIG_FILE_PATH;
            break;

        case "stage":
            filePath = FrameworkConstants.STAGE_CONFIG_FILE_PATH;
            break;

        case "prod":
            filePath = FrameworkConstants.PROD_CONFIG_FILE_PATH;
            break;

        default:
            throw new RuntimeException("Invalid environment : " + environment);

        }

        try (InputStream input = new FileInputStream(filePath)) {

            environmentProperties.load(input);

        } catch (IOException e) {

        	throw new ConfigFileException(
        	        "Unable to load environment properties file.",
        	        e);

        }

    }

    public static String getEnvironmentProperty(String key) {

        String value = environmentProperties.getProperty(key);

        if (value == null || value.trim().isEmpty()) {

        	throw new PropertyNotFoundException(
        	        "Property not found : " + key);

        }

        return value.trim();

    }

}