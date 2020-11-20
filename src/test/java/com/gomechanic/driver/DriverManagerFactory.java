package com.gomechanic.driver;

public class DriverManagerFactory {
	/**
	 * Helps to select the required browser  
	 * @param type
	 */
	public static DriverManager getManager(DriverTypes type) {

		DriverManager driverManager = null;

		switch (type) {
		case Chrome:
			driverManager = new ChromeDriverManager();
			break;
		
		default:
			break;
		}
		return driverManager;
	}
}
