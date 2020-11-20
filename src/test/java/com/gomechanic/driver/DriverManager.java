package com.gomechanic.driver;

import org.openqa.selenium.WebDriver;

public abstract class DriverManager {
	protected WebDriver driver;

	protected abstract void createDriver();
	/**
	 * Closes the opened browser
	 */
	public void quitDriver() {
		if (null != driver) {
			driver.quit();
			driver = null;
		}
	}
	/**
	 * Initialize the driver and launches the browser
	 */
	public WebDriver getDriver() {
		if (null == driver) {
			createDriver();
		}
		return driver;
	}
}
