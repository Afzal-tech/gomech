package com.gomechanic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class WindShieldsPage {

	private WebDriver driver;
	private ExtentTest testLog;
	public WindShieldsPage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}
	public String verifyWindSheildClaimMenuTabText() throws InterruptedException {
	    Thread.sleep(5000);
		String menuText=driver.findElement(By.xpath("//div[text()='Windshields & Glass']")).getText();
		return menuText;
    }
public void selectWindSheildClaimService() {
	try {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Windshields & Glass']/../../..")).click();
		testLog.log(LogStatus.INFO, "User is able to select WindSheilds & Glass Service");
	}catch(Exception ex){
		Assert.fail("Unable to Select WindSheilds & Glass Service");
	}
}

public String verifyHeaderText() throws InterruptedException {
	Thread.sleep(3000);
	String headerText=driver.findElement(By.xpath("//div[text()='Glasses']")).getText();
	return headerText;
 }

public String verifyLightFitmentNameText() throws InterruptedException {
	Thread.sleep(3000);
	String serviceNameText=driver.findElement(By.xpath("//h2[text()='Front Windshield Replacement']")).getText();
	return serviceNameText;
 }

public void clickAddToCart() {
	try {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h2[contains(text(),'Front Windshield Replacement')]/../../../../..//img[@alt='Add to cart']")).click();
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
