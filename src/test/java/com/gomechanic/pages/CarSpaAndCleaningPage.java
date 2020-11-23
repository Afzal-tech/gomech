package com.gomechanic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CarSpaAndCleaningPage {

	private WebDriver driver;
	private ExtentTest testLog;
	public CarSpaAndCleaningPage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}
	
	public String verifyCarSpaCleaningServiceMenuBarText() throws InterruptedException {
	    Thread.sleep(5000);
		String menuText=driver.findElement(By.xpath("//div[text()='Car Spa & Cleaning']")).getText();
		return menuText;
    }
public void selectCarSpaCleaningService() {
	try {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Car Spa & Cleaning']/..")).click();
		testLog.log(LogStatus.INFO, "User is able to select Car Spa Cleaning Service");
	}catch(Exception ex){
		Assert.fail("Unable to Select Car Spa Cleaning Service");
	}
}

public String verifyHeaderText() throws InterruptedException {
	Thread.sleep(3000);
	String headerText=driver.findElement(By.xpath("//div[contains(text(),'Cleaning & Inspection')]")).getText();
	return headerText;
 }

public String verifyServiceNameText() throws InterruptedException {
	Thread.sleep(3000);
	String serviceNameText=driver.findElement(By.xpath("//h2[text()='Car Interior Spa']")).getText();
	return serviceNameText;
 }

public void clickAddToCart() {
	try {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h2[text()='Car Interior Spa']/../../../../..//span[text()='ADD TO CART']")).click();
		testLog.log(LogStatus.INFO, "User is able to Click Add To Cart Button");
	}catch(Exception ex) {
		Assert.fail("Unable to click Add To Cart");
	}
}
}
