package com.gomechanic.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;

import com.relevantcodes.extentreports.ExtentTest;

public class PeriodicServicePage {

	private WebDriver driver;
	private ExtentTest testLog;
	public PeriodicServicePage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}
	
	public String verifyBasicServiceHeaderTitle() {
		String headerTitle=driver.findElement(By.xpath("//div[text()='Scheduled Packages']")).getText();
		return headerTitle;
	}
	
	public String verifyBasicService() {
		String serviceTitle=driver.findElement(By.xpath("//h2[text()='Basic Service']")).getText();
		return serviceTitle;
	}
	
	public boolean addBasicService(String service) {
		String addTocart="//h2[text()='%r']/../../../../..//span[text()='ADD TO CART']";
		addTocart=addTocart.replaceAll("%r", service);
		driver.findElement(By.xpath(addTocart)).click();
		return true;
	}
	
	public void checkCheckBoxBoosters() throws InterruptedException {
		try {
		List<WebElement> e1=driver.findElements(By.xpath("//input[@type='checkbox']/../..//span//div"));
		for(int i=0;i<=e1.size();i++) {
			Thread.sleep(2000);
			e1.get(i).click();
		}
		}catch(Exception ex) {
			System.out.println(ex.getMessage());
		}
	}
	
	public void clickAddBoosterBtn() {
		driver.findElement(By.xpath("//div[@class='ebbIO']")).click();
	}
}

