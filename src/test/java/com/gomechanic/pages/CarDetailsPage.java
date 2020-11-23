package com.gomechanic.pages;
import java.util.Arrays;
import java.util.List;
import java.util.function.Consumer;
import java.util.regex.Pattern;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CarDetailsPage {

	private WebDriver driver;
	private ExtentTest testLog;
	public CarDetailsPage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}

	public void selectCarDetails(Consumer<CarDetailsPage> consumer) {
		consumer.accept(this);
	}

	/**
	 * To verify navigated to Car Details page
	 * 
	 * @return 'true' if navigated to CarDetails Page
	 */
	public boolean verifyNavigatedToCarDetailsPage() {
		return driver.getCurrentUrl().contains("car-repair");
	}

	/**
	 * To select required car brand
	 * 
	 * @param cityname
	 */
	public void selectRequiredCarBrand(String carBrand) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		//try {
			List<WebElement> element = driver
					.findElements(By.xpath("//span[text()='Select Manufacturer']/../../../..//a//img/..//div"));
			for(int i=0;i<=element.size();i++) {
				if (element.get(i).getText().equalsIgnoreCase(carBrand)) {
					element.get(i).click();
					
					try {
						Thread.sleep(3000);
					} catch (InterruptedException e) {
						// TODO Auto-generated catch block
						//e.printStackTrace();
					}
                    break;
					//System.out.println("Hi Rahul");
					//testLog.log(LogStatus.INFO, "Selected Car Brand is " + carBrand);
				}
			}
			//Select carBrands = new Select(element);
//			for (WebElement carbrand : carBrands.getOptions()) {
//				System.out.println("Rahul"+carbrand.getText());
//				if (carbrand.getText().equalsIgnoreCase(carBrand)) {
//					carbrand.click();
//					testLog.log(LogStatus.INFO, "Selected Car Brand is " + carBrand);
//				}
//			}
		//	Thread.sleep(3000);
//		} catch (Exception e) {
//			Assert.fail("Unable to select required Car Brand");
//		}
	}

	/**
	 * To select required car model
	 * 
	 * @param cityname
	 */
	public void selectRequiredCarModel(String carModel) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		//try {
			//WebDriverWait wait = new WebDriverWait(driver, 20);
			//wait.until(ExpectedConditions.visibilityOfAllElementsLocatedBy(
					//By.xpath("//span[text()='Select Model']/../../../..//a//img/..//div']")));
			List<WebElement> element = driver
					.findElements(By.xpath("//span[text()='Select Model']/../../../..//a//img/..//div"));
			for(int i=0;i<=element.size();i++) {
				System.out.println(element.get(i).getText());
				if (element.get(i).getText().equalsIgnoreCase(carModel)) {
					element.get(i).click();
					testLog.log(LogStatus.INFO, "Selected Car Model is " + carModel);
					break;
				}
			}
//			Select carModels = new Select(element);
//			for (WebElement carmodel : carModels.getOptions()) {
//				if (carmodel.getText().equalsIgnoreCase(carModel)) {
//					carmodel.click();
//					testLog.log(LogStatus.INFO, "Selected Car Model is " + carModel);
//				}
//			}
//		} catch (Exception e) {
//			Assert.fail("Unable to select required Car Model");
//		}
	}

	/**
	 * To select required fuel type
	 * 
	 * @param cityname
	 */
	public void selectRequiredFuel(String carFuelType) {
		try {
			Thread.sleep(4000);
		} catch (InterruptedException e1) {
			// TODO Auto-generated catch block
			//e1.printStackTrace();
		}
		//try {
			List<WebElement> element = driver
					.findElements(By.xpath("//span[text()='Select Fuel Type']/../../../..//a//img/..//div"));
			for(int i=0;i<=element.size();i++) {
				if (element.get(i).getText().equalsIgnoreCase(carFuelType)) {
					element.get(i).click();
					testLog.log(LogStatus.INFO, "Selected Car Fuel Type is " + carFuelType);
					break;
				}
			}
//			Select carfueltypes = new Select(element);
//			for (WebElement carfueltype : carfueltypes.getOptions()) {
//				if (carfueltype.getText().equalsIgnoreCase(carFuelType)) {
//					carfueltype.click();
//					testLog.log(LogStatus.INFO, "Selected Car Fuel Type is " + carFuelType);
//				}
//			}
//		} catch (Exception e) {
//			Assert.fail("Unable to select required Fuel type");
//		}
	}
	
	/**
	 * Enter Mobile Number
	 * 
	 * @param Mobile Number
	 */
	public void enterMobileNumber(String mobileNumber) {
	 try {
		Thread.sleep(4000);
	} catch (InterruptedException e) {
		// TODO Auto-generated catch block
		//e.printStackTrace();
	}
	 driver.findElement(By.xpath("//input[@name='mobile']")).sendKeys(mobileNumber);
	}
	
	/**
	 * Check Price Button
	 * 
	 * @param Check Price
	 */
	
	public void clickOnCheckPriceBtn() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		
		driver.findElement(By.xpath("//div[@role='button']")).click();
	}
	/**
	 * To validate car brand
	 */
	public String validateCarBrand() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			//e.printStackTrace();
		}
		String vl=driver.findElement(By.xpath("//h1[text()='The Best Car Service Awaits You']/..//div[2]//span")).getText();
		vl = vl.replace(",","");
		String[] words = vl.split(" ");
        //using java.util.regex Pattern
        Pattern pattern = Pattern.compile(" ");
        words = pattern.split(vl);
        
		return words[0];
	}

	/**
	 * To validate car model
	 * 
	 * @return Car Model detail
	 */
	public String validateCarModel() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			//e.printStackTrace();
		}

		String vl=driver.findElement(By.xpath("//h1[text()='The Best Car Service Awaits You']/..//div[2]//span")).getText();
		vl = vl.replace(",","");
		String[] words = vl.split(" ");
        //using java.util.regex Pattern
        Pattern pattern = Pattern.compile(" ");
        words = pattern.split(vl);
		return words[1];
	}

	/**
	 * To validate car fuel type
	 * 
	 * @return Car Fuel Type
	 */
	public String validateCarFuelType() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			//e.printStackTrace();
		}

		String vl=driver.findElement(By.xpath("//h1[text()='The Best Car Service Awaits You']/..//div[2]//span")).getText();
		vl = vl.replace(",","");
		String[] words = vl.split(" ");
        //using java.util.regex Pattern
        Pattern pattern = Pattern.compile(" ");
        words = pattern.split(vl);
		return words[2];
	}
	public void clickLiveChatCrossIcon() {
		try {
		if(!driver.findElement(By.xpath("//span[@class='cc-g0ak cc-hy0f']")).isDisplayed()) {
		}else {
			driver.findElement(By.xpath("//span[@class='cc-g0ak cc-hy0f']")).click();
		}
		}catch(Exception ex) {
			driver.findElement(By.xpath("//span[@class='cc-g0ak cc-hy0f']")).click();
		}
	}
	
	public void clickLiveChatCrossBtn() {
		try {
			if(!driver.findElement(By.xpath("//span[@class='cc-1asz']")).isDisplayed()) {
				System.out.println("Chat Cross Button Not Display");
			}else {
				driver.findElement(By.xpath("//span[@class='cc-1asz']")).click();
			}
			}catch(Exception ex) {
				driver.findElement(By.xpath("//span[@class='cc-1asz']")).click();
				System.out.println("Click chat button successfully");
			}
	}
}
