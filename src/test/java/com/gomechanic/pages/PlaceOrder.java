package com.gomechanic.pages;

import java.util.Calendar;
import java.util.Date;
import java.util.TimeZone;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.interactions.Actions;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class PlaceOrder {

	private WebDriver driver;
	private ExtentTest testLog;
	
	public PlaceOrder(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}
	
	public void clickOnProceedToCheckOut() {
		try {
		driver.findElement(By.xpath("//div[text()='CHECKOUT']")).click();
		testLog.log(LogStatus.INFO, "Click on checkout Button");
		}catch(Exception ex) {
			Assert.fail("Unable to click checkout button");
		}
	}
	
	public void clickContinueBtnAccount() {
		try {
			driver.findElement(By.xpath("//div[text()='CONTINUE']/../..")).click();
			testLog.log(LogStatus.INFO, "User is able to click account continue button");
		}catch(Exception ex) {
			Assert.fail("Unable to click Account Continue Button");
		}
	}
	
	public void enterOtpAccount() {
		try {
			driver.findElement(By.xpath("//input[@placeholder='One Time Password']")).sendKeys("0000");
			testLog.log(LogStatus.INFO, "User is able to enter otp");
		}catch(Exception ex) {
			Assert.fail("Unable to enter otp");
		}
	}
	
	public void clickVerifyOtpBtn() {
		try {
			driver.findElement(By.xpath("//div[text()='VERIFY OTP']/../..")).click();
			testLog.log(LogStatus.INFO, "User is able to click verify otp button");
		}catch(Exception ex) {
			Assert.fail("Unable to click verify otp button");
		}
	}
	public void selectDate() throws InterruptedException {
		try {
		Calendar calendar = Calendar.getInstance(TimeZone.getDefault());
		Date date = calendar.getTime();
        int day = calendar.get(Calendar.DATE)+1;
        Thread.sleep(4000);
		System.out.println("Current Day is:: " + day);
		driver.findElement(By.xpath("//div[text()='"+day+"']/../..")).click();
		testLog.log(LogStatus.INFO, "User is able to select date");
		}catch(Exception ex) {
			Assert.fail("Unable to select Date slot");
		}
	}
	
	public void selectTimeSlot() {
		try {
			driver.findElement(By.xpath("//div[text()='02PM']/../..")).click();
			testLog.log(LogStatus.INFO, "User is able to select time");
		}catch(Exception ex) {
			Assert.fail("Unable to select Time slot");
		}
	}
	
	public void clickContinueBtn() {
		try {
			driver.findElement(By.xpath("//p[text()='CONTINUE']/..")).click();
			testLog.log(LogStatus.INFO, "User is able to click on continue button");
		}catch(Exception ex) {
			Assert.fail("Unable to click continue button");
		}
	}
	
	public void selectAddress() {
		try {
			driver.findElement(By.xpath("(//p[text()='SELECT ']/..)[2]")).click();
			testLog.log(LogStatus.INFO, "User is able to select address");
		}catch(Exception ex) {
			Assert.fail("Unable to select address");
		}
	}
	
	public void clickContinueBtnAdd() {
		try {
			driver.findElement(By.xpath("//div[text()='Continue']/../..")).click();
			testLog.log(LogStatus.INFO, "User is able to click continue button for address");
		}catch(Exception ex) {
			Assert.fail("Unable to click continue button for address");
		}
	}
	
	public void clickPaymentCod() {
		try {
			driver.findElement(By.xpath("//p[text()='Pay Via Cash After Service']/..")).click();
			testLog.log(LogStatus.INFO, "User is able to select cash on delivery");
		}catch(Exception ex) {
			Assert.fail("Unable to click continue button for address");
		}
	}
	
	public void clickPlaceOrder() {
		try {
			Actions a=new Actions(driver);
			a.moveToElement(driver.findElement(By.xpath("//p[contains(text(),'PLACE ORDER')]/.."))).build().perform();
			Thread.sleep(3000);
			driver.findElement(By.xpath("//p[contains(text(),'PLACE ORDER')]/..")).click();
			testLog.log(LogStatus.INFO, "User is able to click place order");
		}catch(Exception ex) {
			Assert.fail("Unable to place order");
		}
	}
}
