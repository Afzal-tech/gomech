package com.gomechanic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class InsuranceClaimPage {

	private WebDriver driver;
	private ExtentTest testLog;
	public InsuranceClaimPage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}
	
	public String verifyInsuranceClaimServiceMenuBarText() throws InterruptedException {
	    Thread.sleep(5000);
		String menuText=driver.findElement(By.xpath("//div[text()='Insurance Claims']")).getText();
		return menuText;
    }
public void selectInsuranceClaimService() {
	try {
		Thread.sleep(5000);
		driver.findElement(By.xpath("//div[text()='Insurance Claims']/..")).click();
		testLog.log(LogStatus.INFO, "User is able to select Insurance Claim Service");
	}catch(Exception ex){
		Assert.fail("Unable to Select Insurance Claim Service");
	}
}

public String verifyHeaderText() throws InterruptedException {
	Thread.sleep(3000);
	String headerText=driver.findElement(By.xpath("//div[text()='Accidental Repairs']")).getText();
	return headerText;
 }

public String verifyServiceNameText() throws InterruptedException {
	Thread.sleep(3000);
	String serviceNameText=driver.findElement(By.xpath("//h2[text()='Doorstep Accidental Inspection']")).getText();
	return serviceNameText;
 }

public void clickAddToCart() {
	try {
		Thread.sleep(3000);
		driver.findElement(By.xpath("//h2[text()='Doorstep Accidental Inspection']/../../../../..//span[text()='ADD TO CART']")).click();
		testLog.log(LogStatus.INFO, "User is able to Click Add To Cart Button");
	}catch(Exception ex) {
		Assert.fail("Unable to click Add To Cart");
	}
}
}
