package com.gomechanic.pages;

import java.util.List;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.gomechanic.utils.WindowsHandler;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class HomePage {

	public WebDriver driver;
	private ExtentTest testLog;

	public HomePage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}

	/**
	 * To select required tab from header section
	 * 
	 * @param SubmoduleName
	 */
	public void clickOnRequiredTab(String tabName) {
		try {
			List<WebElement> modules = driver.findElements(By.cssSelector("div[id='top-menu-bar'] ul li a"));
			for (WebElement module : modules) {
				if (module.getText().equalsIgnoreCase(tabName)) {
					module.click();
					break;
				}
			}
			WindowsHandler.switchToChildWindowDirectly(driver);
			testLog.log(LogStatus.INFO, "Clicked on '" + tabName + "' tab");
		} catch (Exception e) {
			Assert.fail("Unable to click on " + tabName + " tab");
		}
	}

	/**
	 * To validate whether user is navigated to Car Enquiry Page or not
	 * 
	 * @return 'message' if navigated to Car Enquiry page
	 */
	public String validateUserNavigatedToCarEnquiryPage() {
		String url = driver.getCurrentUrl();
		return url;
	}

	/**
	 * To click on Cart link from header section
	 * 
	 * @return @throws
	 */
	public CartPage clickOnCartIcon() {
		try {
			WebElement floatingElement = driver.findElement(By.cssSelector("a#show-cart-button-floating-menu"));
			if (floatingElement.isDisplayed()) {
				floatingElement.click();
			} else {
				WebElement element = driver.findElement(By.cssSelector("div#myNavbar>ul>li>a[id='show-cart-button"));
				JavascriptExecutor executor = (JavascriptExecutor) driver;
				executor.executeScript("arguments[0].click();", element);
			}
			testLog.log(LogStatus.INFO, "Clicked on Cart Icon");
		} catch (Exception e) {
			Assert.fail("Unable to click on Cart Icon");
		}
		return new CartPage(driver, testLog);
	}

	/**
	 * To click on Services tab
	 * 
	 * @return To 'Car Details' page
	 */
	public CarDetailsPage clickOnServicesTab() {
		try {
			driver.findElement(By.xpath("//span[text()='SELECT YOUR CAR']/..//img")).click();
			testLog.log(LogStatus.INFO, "Clicked on the Services tab");
			WindowsHandler.switchToChildWindowDirectly(driver);
		} catch (Exception e) {
			Assert.fail("Unable to click on Sevices tab");
		}
		return new CarDetailsPage(driver, testLog);

	}

		public InsurancePage clickOnInsuranceTab() {
		try {
			driver.findElement(
					By.cssSelector("div[id='top-menu-bar'] ul li a[href^='http://uat.gomechanic.in/car-insurance']"))
					.click();
			testLog.log(LogStatus.INFO, "Clicked on the Insurance tab");
			WindowsHandler.switchToChildWindowDirectly(driver);
		} catch (Exception e) {
			Assert.fail("Unable to click on Insurance tab");
		}
		return new InsurancePage(driver, testLog);

	}

	
	/**
	 * To click on 'Give Requirements' button present on Home page
	 */
	public void clickOnGiveRequirementsButton() {
		try {
			WebElement element = driver.findElement(By.cssSelector("input[id='requirement-desktop-button-call']"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			testLog.log(LogStatus.INFO, " Clicked on 'Give Requirements' button present on Home page");
		} catch (Exception e) {
			Assert.fail("Unable to click on 'Give Requirements' button present on Home page");
		}
	}

	/**
	 * To enter mobile number in the Mobile Number field on 'Give Requirements' pop
	 * up
	 */
	public void enterMobileNumberOnGiveRequirementsPopup(String mobileNumber) {
		try {
			driver.findElement(By.cssSelector("input[id='request-call-website-number']")).sendKeys(mobileNumber);
			testLog.log(LogStatus.INFO, " Entered mobile number on 'Give Requirements' popup is: " + mobileNumber);
			Thread.sleep(2000);
		} catch (Exception e) {
			Assert.fail("Unable to enter mobile number on Give Requirements popup");
		}
	}

	/**
	 * To Click on 'Request Call Back' button
	 * 
	 * @throws InterruptedException
	 */
	public void clickOnRequestCallBackButton() {
		try {
			WebElement element = driver.findElement(By.cssSelector("input[id='requirement-submit-button-text']"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			testLog.log(LogStatus.INFO, "Clicked on Request Call Back button on Give Requirements popup");
			Thread.sleep(2000);
		} catch (Exception e) {
			Assert.fail("Unable to click on Request Call Back button on Give Requirements popup");
		}
	}

	/**
	 * To Verify '"Please enter a valid Number"' alert error message on Home page
	 * 
	 * @return 'Alert' message
	 */
	public String verifyAlertMessage() {
		return driver.findElement(By.cssSelector("p#alert-text")).getText();
	}

	/**
	 * To verify 'Oops! It's Empty' message
	 */
	public String verifyEmptyCartErrorMessage() {
		String message = driver.findElement(By.cssSelector("div[class='pop-over-mobile col-xs-12']")).getText();
		return message;
	}


	/**
	 * To click on 'BOOK A CLEANING SERVICE' link under 'Services' section
	 * 
	 * @return To 'Car Details' page
	 */
	public CarDetailsPage clickOnBookACleaningServiceLink() {
		try {
			driver.findElement(By.cssSelector(
					"div[class*='row service']>div:nth-child(2)>div[class*='service-content']>a[class*='hidden']"))
					.click();
			testLog.log(LogStatus.INFO, "Clicked on 'BOOK A CLEANING SERVICE' link from 'Services' section");
		} catch (Exception e) {
			Assert.fail("Unable to click on 'BOOK A CLEANING SERVICE' link from 'Services' section");
		}
		return new CarDetailsPage(driver, testLog);
	}

	/**
	 * To click on 'BOOK A WHEELCARE SERVICE' link under 'Services' section
	 * 
	 * @return To 'Car Details' page
	 */
	public CarDetailsPage clickOnBookAWheelCareServiceLink() {
		try {
			driver.findElement(By.cssSelector(
					"div[class*='row service']>div:nth-child(3)>div[class*='service-content']>a[class*='hidden']"))
					.click();
			testLog.log(LogStatus.INFO, "Clicked on 'BOOK A WHEELCARE SERVICE' link from 'Services' section");
		} catch (Exception e) {
			Assert.fail("Unable to 'BOOK A WHEELCARE SERVICE' link from 'Services' section");
		}
		return new CarDetailsPage(driver, testLog);
	}

	/**
	 * To click on 'BOOK A DENT PAINT SERVICE' link under 'Services' section
	 * 
	 * @return To 'Car Details' page
	 */
	public CarDetailsPage clickOnBookADentPaintServiceLink() {
		try {
			driver.findElement(By.cssSelector(
					"div[class*='row service']>div:nth-child(4)>div[class*='service-content']>a[class*='hidden']"))
					.click();
			testLog.log(LogStatus.INFO, "Clicked on 'BOOK A DENT PAINT SERVICE' link from 'Services' section");
		} catch (Exception e) {
			Assert.fail("Unable to click on 'BOOK A DENT PAINT SERVICE' link from 'Services' section");
		}
		return new CarDetailsPage(driver, testLog);
	}

	/**
	 * Verifies 'Please Select Car Details' error message on home page
	 * 
	 * @return 'Error Message' for Check Price
	 */
	public String verifyCheckPriceErrorMessage() {
		return driver.findElement(By.cssSelector("div#error-message")).getText();
	}

	

	/**
	 * To click on See More link
	 */
	public void clickOnSeeMoreLink() {
		driver.findElement(By.cssSelector("a#see-more")).click();
	}

	/**
	 * Verify user is navigated to Frequently Asked Questions page
	 * 
	 * @return 'true' if navigated to 'Faq' page
	 */
//	public boolean verifyUserNavigatedToFAQPage() {
//		String URL = driver.getCurrentUrl();
//		Predicate<String> p = i -> i.contains("faq");
//		return p.test(URL);
//	}

	/**
	 * To click on 'Select Your Car Details' drop down from home page
	 */
	public void clickOnSelectCarDetails() {
		try {
			driver.findElement(By.cssSelector("input[id='input-selected-car']")).click();
			testLog.log(LogStatus.INFO, "Clicked on 'Select Your Car Details' dropdown");
		} catch (Exception e) {
			Assert.fail("Unable to click on 'Select Your Car Details' dropdown");
		}
	}

	/**
	 * To select the Car brand name from Home page
	 * 
	 * @param carbrand
	 */
	public void selectCarBrandName(String carBrand) {
		try {
			List<WebElement> carBrands = driver
					.findElements(By.cssSelector("ul[class='list-group process-list'][id='brand-list'] li a"));
			for (WebElement carbrand : carBrands) {
				if (carbrand.getText().equals(carBrand)) {
					testLog.log(LogStatus.INFO, "Selected Car Brand is " + carBrand);
					carbrand.click();
				}
			}
		} catch (Exception e) {
			Assert.fail("Unable to select " + carBrand + " Car Brand");
		}
	}

	/**
	 * To select the car model name from Home page
	 * 
	 * @param carmodelname
	 */
	public void selectCarModelName(String carModelName) {
		try {
			List<WebElement> carModelNames = driver
					.findElements(By.cssSelector("ul[class='list-group process-list'][id='model-list'] li a"));
			for (WebElement carmodelname : carModelNames) {
				if (carmodelname.getText().equals(carModelName)) {
					carmodelname.click();
					testLog.log(LogStatus.INFO, "Selected Car Model is  " + carModelName);
				}
			}
		} catch (Exception e) {
			Assert.fail("Unable to select " + carModelName + " Car Model");
		}
	}

	/**
	 * To select car fuel type from Home page
	 * 
	 * @param carfueltype
	 */
	public void selectCarFuelType(String carFuelType) {
		try {
			testLog.log(LogStatus.INFO, "Selected car brand " + carFuelType);
			List<WebElement> carFuelTypes = driver
					.findElements(By.cssSelector("ul[class='list-group process-list'][id='fuel-list'] li a"));
			for (WebElement carfueltype : carFuelTypes) {
				if (carfueltype.getText().equals(carFuelType)) {
					carfueltype.click();
					testLog.log(LogStatus.INFO, "Selected Car Fuel Type is " + carFuelType);
				}
			}
		} catch (Exception e) {
			Assert.fail("Unable to select " + carFuelType + " Car Fuel type");
		}
	}

	/**
	 * To enter mobile number in 'Check Price' section
	 * 
	 * @param mobileNumber
	 */
	public void enterMobileNumber(String mobileNumber) {
		try {
			driver.findElement(By.cssSelector("input[id='client-number']")).sendKeys(mobileNumber);
			testLog.log(LogStatus.INFO, "Entered Mobile number is '" + mobileNumber);
		} catch (Exception e) {
			Assert.fail("Unable to enter Mobile number");
		}
	}

	/**
	 * To Verify user navigated to Home page from Car Enquiry page GoMechanic logo
	 * 
	 * @return 'Message' if navigated to 'Home' page
	 */
	public String verifyUserNaviagtedToHomePage() {
		String text = driver.findElement(By.cssSelector("a[id='home-nav']")).getText();
		return text;
	}
}
