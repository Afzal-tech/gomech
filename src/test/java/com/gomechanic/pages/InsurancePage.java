package com.gomechanic.pages;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.Select;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class InsurancePage {

	private WebDriver driver;
	private ExtentTest testLog;

	public InsurancePage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}

	/**
	 * To verify navigated to insurance page
	 * 
	 * @return 'true' if navigated to Insurance page
	 */
	public boolean verifyNavigatedToInsurancePageByURL() {
		return driver.getCurrentUrl().contains("car-insurance");
	}

	/**
	 * To click on Get Quote button
	 * 
	 * @throws InterruptedException
	 */
	public void clickOnGetQuoteButton() {
		try {
			driver.findElement(By.cssSelector("div#standard-service>div>div[class='add-to-cart-btn']")).click();
			testLog.log(LogStatus.INFO, " Clicked on the Get Quote button");
			Thread.sleep(2000);
		} catch (Exception e) {
			Assert.fail("Unable to click on Get Quote button");
		}
	}

	/**
	 * To Verify select required car brand
	 * 
	 * @param cityname
	 * @throws InterruptedException
	 */
	public void selectRequiredCarBrand(String carBrand) {
		try {
			WebElement element = driver
					.findElement(By.cssSelector("div[class='car-select-modal']>select[id='brand-name-popUp']"));
			Select carBrands = new Select(element);
			for (WebElement carBrandName : carBrands.getOptions()) {
				if (carBrandName.getText().equalsIgnoreCase(carBrand)) {
					carBrandName.click();
					testLog.log(LogStatus.INFO, "Selected Car Brand is: " + carBrand);
					break;
				}
			}
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail("Unable to select " + carBrand + " Car Brand");
		}
	}

	/**
	 * To verify select required car model
	 * 
	 * @param cityname
	 */
	public void selectRequiredCarModel(String carModelName) {
		try {
			WebElement element = driver
					.findElement(By.cssSelector("div[class='car-select-modal']>select[id='model-name-popUp']"));
			Select carModels = new Select(element);
			for (WebElement carModel : carModels.getOptions()) {
				if (carModel.getText().equalsIgnoreCase(carModelName)) {
					carModel.click();
					testLog.log(LogStatus.INFO, "Selected Car Model is: " + carModelName);
					break;
				}
			}
		} catch (Exception e) {
			Assert.fail("Unable to select " + carModelName + " Car Model name");
		}
	}

	/**
	 * To Verify select required fuel type
	 * 
	 * @param cityname
	 */
	public void selectRequiredFuel(String carFuelType) {
		try {
			WebElement element = driver
					.findElement(By.cssSelector("div[class='car-select-modal']>select[id='fuel-name-popUp']"));
			Select carFuelTypes = new Select(element);
			for (WebElement carFuel : carFuelTypes.getOptions()) {
				if (carFuel.getText().equalsIgnoreCase(carFuelType)) {
					carFuel.click();
					testLog.log(LogStatus.INFO, "Selected Car Fuel Type is: " + carFuelType);
					break;
				}
			}
		} catch (Exception e) {
			Assert.fail("Unable to select " + carFuelType + " Car Fuel type");
		}
	}

	/**
	 * To click on 'Find Service' button
	 * 
	 * @return To 'Insurance' page
	 */
	public InsurancePage clickOnFindService() {
		try {
			driver.findElement(By.cssSelector("input[value='FIND SERVICE']")).click();
			testLog.log(LogStatus.INFO, "Clicked on Find Service button");
		} catch (Exception e) {
			Assert.fail("Unable to click on Find Service button");
		}
		return new InsurancePage(driver, testLog);
	}

	/**
	 * To validate selected car brand name on Service page
	 */
	public String verifyCarBrandOnInsuarancePage() {
		return driver.findElement(By.cssSelector("a[id='carBrand']")).getText();
	}

	/**
	 * To validate selected car model name on Service page
	 * 
	 * @return 'Car Model' if Car Model is available on Insurance page
	 */
	public String verifyCarModelOnInsuarancePage() {
		return driver.findElement(By.cssSelector("a#carModel")).getText();
	}

	/**
	 * To validate selected car fuel type on Service page
	 * 
	 * @return car 'Fuel' type on Insurance page
	 */
	public String verifyCarFuelTypeOnInsuarancePage() {
		String fueltype = driver.findElement(By.cssSelector("a#carName")).getText();
		return fueltype;
	}

	/**
	 * To click on 'Request Call Back' Button from Car Insurance page
	 * 
	 * @throws InterruptedException
	 */
	public void clickOnRequestCallBackBtn() throws InterruptedException {
		try {
			driver.findElement(By.cssSelector("input[id='requirement-submit-button-text']")).click();
			testLog.log(LogStatus.INFO, "Clicked on Request Call Back button");
			Thread.sleep(5000);
		} catch (Exception e) {
			Assert.fail("Unable to click on Request Call Back button");
		}
	}

	/**
	 * To Verify '"Please enter a valid Number"' alert error message on Insurance
	 * page
	 * 
	 * @return message
	 */
	public String verifyAlertMessage() {
		return driver.findElement(By.cssSelector("p#alert-text")).getText();
	}

	/**
	 * To enter mobile number on Request Call Back popup
	 */
	public void enterMobileNumberOnRequestCallBackPopup(String mobileNumber) {
		try {
			driver.findElement(By.cssSelector("input#request-call-website-number")).sendKeys(mobileNumber);
			testLog.log(LogStatus.INFO, "Entered mobile number is: " + mobileNumber);
		} catch (Exception e) {
			Assert.fail("Unable to enter Mobile number");
		}
	}

	/**
	 * To verify user is navigated to car Insurance page
	 * 
	 * @return 'true' if navigated to Insurance page
	 */
	public boolean verifyUserNavigatedToInsurancePageByURL() {
		return driver.getCurrentUrl().contains("car-insurance");
	}
}
