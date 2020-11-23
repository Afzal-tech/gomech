package com.gomechanic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DetailingServicesPage {

	private WebDriver driver;
	private ExtentTest testLog;
	public DetailingServicesPage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}
	
	public String verifyDetailingServiceMenuBarText() throws InterruptedException {
	    Thread.sleep(5000);
		String menuText=driver.findElement(By.xpath("//div[text()='Detailing Services']")).getText();
		return menuText;
    }
public void selectDetailingService() {
	try {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Detailing Services']/..")).click();
		testLog.log(LogStatus.INFO, "User is able to select Detailing Service");
	}catch(Exception ex){
		Assert.fail("Unable to Select Detailing Service");
	}
}

public String verifyHeaderText() throws InterruptedException {
	Thread.sleep(3000);
	String headerText=driver.findElement(By.xpath("//div[text()='Detailing & Coatings']")).getText();
	return headerText;
 }

public String verifyServiceNameText() throws InterruptedException {
	Thread.sleep(3000);
	String serviceNameText=driver.findElement(By.xpath("//h2[text()='PPF - Paint Protection Film']")).getText();
	return serviceNameText;
 }

public void clickAddToCart() {
	try {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h2[text()='PPF - Paint Protection Film']/../../../../..//span[text()='ADD TO CART']")).click();
		testLog.log(LogStatus.INFO, "User is able to Click Add To Cart Button");
	}catch(Exception ex) {
		Assert.fail("Unable to click Add To Cart");
	}
}
public void clickScrollMenuBarRight() {
	try {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//img[@alt='Right Arrow']/..")).click();
	}catch(Exception ex) {
		Assert.fail("Unable to Scroll Right Menu Bar");
	}
}
}
