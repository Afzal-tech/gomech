package com.gomechanic.utils;

import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

public class JavaScriptExecutor {
	/**
	 * scrolls upto end of page
	 * 
	 * @param driver
	 */
	public static void scrollCompletePagedown(WebDriver driver) {
		JavascriptExecutor execute = ((JavascriptExecutor) driver);
		execute.executeScript("window.scrollTo(0, document.body.scrollHeight)");
	}

	/**
	 * scrolls upto required element
	 * 
	 * @param driver,element
	 */
	public static void scrollUptoElement(WebDriver driver, WebElement element) {
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("arguments[0].scrollIntoView(true);", element);
	}

	/**
	 * scrolls upto required element and clicks on it
	 * 
	 * @param driver,element
	 */
	public static void clickOnElement(WebDriver driver, WebElement element) {
		JavascriptExecutor execute = (JavascriptExecutor) driver;
		execute.executeScript("arguments[0].click();", element);
	}
}
