package com.gomechanic.utils;

import java.util.ArrayList;
import java.util.Set;

import org.openqa.selenium.WebDriver;

public class WindowsHandler {
	/**
	 * Switch to required child window based on title
	 * @param driver
	 * @param Title
	 */
	public static void switchToChildWindowByTitle(WebDriver driver, String Title) {
		Set<String> childwindows = driver.getWindowHandles();
		for (String childwindow : childwindows) {
			if (driver.switchTo().window(childwindow).getTitle().equals(Title)) {
				break;
			}
		}
	}
	/**
	 * Switch to 1st child window only
	 * @param driver
	 */
	public static void switchToChildWindowDirectly(WebDriver driver) {
		Set<String> childWindows = driver.getWindowHandles();
		ArrayList<String> windows = new ArrayList<String>(childWindows);
		for (int i = 1; i < windows.size(); i++) {
			driver.switchTo().window(windows.get(i));
			break;
		}
	}
	/**
	 * Closes all opened child window
	 * @param driver
	 */
	public static void closeAllChildWindows(WebDriver driver) {
		Set<String> childWindows = driver.getWindowHandles();
		ArrayList<String> windows = new ArrayList<String>(childWindows);
		for (int i = 1; i < windows.size(); i++) {
			driver.switchTo().window(windows.get(i));
			driver.close();
		}
	}
	/**
	 * Switch to parent/main window
	 * @param driver
	 */
	public static void switchToParentWindow(WebDriver driver) {
		Set<String> windowIds = driver.getWindowHandles();
		ArrayList<String> windowsList = new ArrayList<String>(windowIds);
		driver.switchTo().window(windowsList.get(0));
	}
}
