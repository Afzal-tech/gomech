package com.gomechanic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class DentingAndPaintingPage {

	private WebDriver driver;
	private ExtentTest testLog;
	public DentingAndPaintingPage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}
	
	public String verifyDentingAndPaintingServiceMenuBarText() throws InterruptedException {
	    Thread.sleep(5000);
		String menuText=driver.findElement(By.xpath("//div[text()='Denting & Painting']")).getText();
		return menuText;
    }
public void selectDentingAndPaintingService() {
	try {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Denting & Painting']/..")).click();
		testLog.log(LogStatus.INFO, "User is able to select Denting&Painting Service");
	}catch(Exception ex){
		Assert.fail("Unable to Select Denting&Painting Service");
	}
}

public String verifyHeaderText() throws InterruptedException {
	Thread.sleep(3000);
	String headerText=driver.findElement(By.xpath("//div[text()='Whole Body']")).getText();
	return headerText;
 }

public String verifyServiceNameText() throws InterruptedException {
	Thread.sleep(3000);
	String serviceNameText=driver.findElement(By.xpath("//h2[text()='Full Body Dent Paint']")).getText();
	return serviceNameText;
 }

public void clickAddToCart() {
	try {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h2[text()='Full Body Dent Paint']/../../../../..//span[text()='ADD TO CART']")).click();
		testLog.log(LogStatus.INFO, "User is able to Click Add To Cart Button");
	}catch(Exception ex) {
		Assert.fail("Unable to click Add To Cart");
	}
}

public String verifyAddOn() throws InterruptedException {
	Thread.sleep(4000);
	String addon=driver.findElement(By.xpath("(//div[text()='Full Body Dent Paint'])[2]")).getText();
	return addon;
	
}

public void clickAddBtn() {
	try {
		Thread.sleep(2000);
		driver.findElement(By.xpath("//div[text()='+ ADD']")).click();
		testLog.log(LogStatus.INFO, "User is able to Click Add Button");
	}catch(Exception ex) {
		Assert.fail("Unable to click Add Button");
	}
}

}
