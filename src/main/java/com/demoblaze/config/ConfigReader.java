package com.demoblaze.config;

import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Properties;

import com.demoblaze.constants.FrameworkConstants;

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
		
		try(InputStream input = new FileInputStream(FrameworkConstants.CONFIG_FILE_PATH)){
			properties.load(input);
		}catch (IOException e) {
			throw new RuntimeException(
					"Unable to load config.properties file :" + FrameworkConstants.CONFIG_FILE_PATH, e);
		}
	}
	
	public static String getProperty(String key) {
		String value = properties.getProperty(key);
		
		if (value == null ||value.trim().isEmpty()) {
			throw new RuntimeException("Property '"+key+"'not found in config.properties");
		}
		
		return value.trim();
	}

}
