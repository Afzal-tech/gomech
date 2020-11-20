package com.gomechanic.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class SelectCityPage {

	private WebDriver driver;
	private ExtentTest testLog;

	public SelectCityPage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}

	/**
	 * To verify Page Title
	 * 
	 * @return 'Title' for selected City page
	 */
	public String verifyTitle() {
		return driver.getCurrentUrl();
	}

	/**
	 * To select required city name
	 * 
	 * @param cityname
	 * @return To 'Home' page
	 */

	public HomePage selectRequiredCity(String cityName) {
		try {
			driver.findElement(By.cssSelector("img[class^='_3fheq']")).click();
			//clickOnCityName(cityName);
		} catch (Exception e) {
			//clickOnCityName(cityName);
		}
		return new HomePage(driver, testLog);
	}

	/**
	 * To click on City Name
	 * 
	 * @param cityname
	 */
	public void clickOnCityName(String cityName) {
		try {
			WebDriverWait wait = new WebDriverWait(driver, 5);
			List<WebElement> cityNames = driver
					.findElements(By.xpath("//div[text()='Choose Your City']/../../..//div[@class='_3kY_h']"));
			for (WebElement cityname : cityNames) {
				wait.until(ExpectedConditions.elementToBeClickable(cityname));
				if (cityname.getText().equalsIgnoreCase(cityName)) {
					cityname.click();
					System.out.println(cityname);
					testLog.log(LogStatus.INFO, "Clicked on: " + cityName);
					break;
				}
			}
		} catch (Exception e) {
			Assert.fail("Unable to click " + cityName);
		}
	}

	/**
	 * To validate city is selected or not
	 * 
	 * @return 'City name'
	 */
	public String validateSelectedCity() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		return driver.findElement(By.xpath("//div[text()='Choose Your City']/../../..//div[text()='Hyderabad']")).getText();
	}
}
