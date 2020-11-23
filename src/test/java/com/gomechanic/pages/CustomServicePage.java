package com.gomechanic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CustomServicePage {

	private WebDriver driver;
	private ExtentTest testLog;
	public CustomServicePage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}
	
	public String verifyCustomServiceMenuBarText() throws InterruptedException {
	    Thread.sleep(5000);
		String menuText=driver.findElement(By.xpath("//div[text()='Custom Services']")).getText();
		return menuText;
    }
public void selectCustomService() {
	try {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Custom Services']/..")).click();
		testLog.log(LogStatus.INFO, "User is able to select Custom Service");
	}catch(Exception ex){
		Assert.fail("Unable to Select Custom Service");
	}
}

public String verifyHeaderText() throws InterruptedException {
	Thread.sleep(3000);
	String headerText=driver.findElement(By.xpath("//div[text()='Inspection']")).getText();
	return headerText;
 }

public String verifyServiceNameText() throws InterruptedException {
	Thread.sleep(3000);
	String serviceNameText=driver.findElement(By.xpath("//h2[text()='Engine Scanning']")).getText();
	return serviceNameText;
 }

public void clickAddToCart() {
	try {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h2[text()='Engine Scanning']/../../../../..//span[text()='ADD TO CART']")).click();
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
