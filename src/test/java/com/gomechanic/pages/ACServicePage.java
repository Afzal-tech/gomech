package com.gomechanic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class ACServicePage {

	private WebDriver driver;
	private ExtentTest testLog;
	public ACServicePage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}
	
	public String verifyACServiceMenuBarText() throws InterruptedException {
		    Thread.sleep(5000);
			String menuText=driver.findElement(By.xpath("//div[text()='AC Services']")).getText();
			return menuText;
        }
	public void selectACService() {
		try {
			Thread.sleep(5000);
			driver.findElement(By.xpath("//div[text()='AC Services']/..")).click();
			testLog.log(LogStatus.INFO, "User is able to select AC Service");
		}catch(Exception ex){
			Assert.fail("Unable to Select AC Service");
		}
	}
	
	public String verifyHeaderText() throws InterruptedException {
		Thread.sleep(3000);
		String headerText=driver.findElement(By.xpath("//div[text()='AC Service Packages']")).getText();
		return headerText;
	 }
	
	public String verifyServiceNameText() throws InterruptedException {
		Thread.sleep(3000);
		String serviceNameText=driver.findElement(By.xpath("//h2[text()='Regular AC Service']")).getText();
		return serviceNameText;
	 }
	
	public void clickAddToCart() {
		try {
			Thread.sleep(3000);
			driver.findElement(By.xpath("//h2[text()='Regular AC Service']/../../../../..//img[@alt='Add to cart']")).click();
			testLog.log(LogStatus.INFO, "User is able to Click Add To Cart Button");
		}catch(Exception ex) {
			Assert.fail("Unable to click Add To Cart");
		}
	}
	}
