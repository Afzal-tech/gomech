package com.gomechanic.utils;

import java.io.File;
import java.io.FileInputStream;
import java.util.Properties;

public class ConfigFileReader {

	private File file;
	private FileInputStream fis;
	private Properties properties;
	private String filePath = "./config/configuration.properties";

	/**
	 * To load the 'File' properties
	 * 
	 * @throws Exception
	 */
	public void loadProperties() throws Exception {
		file = new File(filePath);
		fis = new FileInputStream(file);
		properties = new Properties();
		properties.load(fis);
	}

	/**
	 * To get the value from properties file based on key
	 * 
	 * @param key
	 * @return 'Key' value
	 * @throws Exception
	 */
	public String getKey(String key) {
		try {
			loadProperties();
		} catch (Exception e) {
			e.printStackTrace();
		}
		return properties.getProperty(key);
	}

	/**
	 * To get configuration properties file
	 * 
	 * @return reportConfigPath
	 */
	public String getReportConfigPath() {
		String reportConfigPath = properties.getProperty("reportConfigPath");
		if (reportConfigPath != null)
			return reportConfigPath;
		else
			throw new RuntimeException(
					"Report Config Path not specified in the Configuration.properties file for the Key:reportConfigPath");
	}
}
