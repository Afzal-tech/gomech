package com.gomechanic.pages;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Predicate;

import org.openqa.selenium.By;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CheckOutPage {
	private WebDriver driver;
	private ExtentTest testLog;

	public CheckOutPage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}

	public void enterUserDetails(Consumer<CheckOutPage> consumer) {
		consumer.accept(this);
	}

	/**
	 * To enter phoneNumber in checkout page
	 * 
	 * @param phoneNumber
	 */
	public void enterPhoneNumber(String phoneNumber) {
		try {
			driver.findElement(By.cssSelector("input[id='checkout-number']")).sendKeys(phoneNumber);
			testLog.log(LogStatus.INFO, "Entered Phone Number is " + phoneNumber);
		} catch (Exception e) {
			Assert.fail("Unable to enter Phone number");
		}
	}

	/**
	 * To enter name in checkout page
	 * 
	 * @param userName
	 */
	public void enterName(String userName) {
		try {
			driver.findElement(By.cssSelector("input[id='checkout-name']")).sendKeys(userName);
			testLog.log(LogStatus.INFO, "Entered Name is " + userName);
		} catch (Exception e) {
			Assert.fail("Unable to enter Name");
		}
	}

	/**
	 * To enter Email id in checkout page
	 * 
	 * @param emailId
	 */
	public void enterEmailId(String emailId) {
		try {
			driver.findElement(By.cssSelector("input[id='email-id']")).sendKeys(emailId);
			testLog.log(LogStatus.INFO, "Entered EmailId is " + emailId);
		} catch (Exception e) {
			Assert.fail("Unable to enter Email Id");
		}
	}

	/**
	 * To select pickUp Date in checkout page
	 * 
	 * @param numberOfDaysFromTodaysDate
	 */
	public void selectPickUpDate(String numberOfDaysFromTodaysDate) {
		SimpleDateFormat sdf = new SimpleDateFormat("dd");
		Calendar cal = Calendar.getInstance();
		cal.add(Calendar.DAY_OF_MONTH, Integer.parseInt(numberOfDaysFromTodaysDate));
		String newDate = sdf.format(cal.getTime());
		int a = Integer.parseInt(newDate);
		List<WebElement> pickupdates = driver
				.findElements(By.cssSelector("[class='scroll-div'] div[class='pick-date-div all-dates-div'] div"));
		for (WebElement pickupdate : pickupdates) {
			int b = Integer.parseInt(pickupdate.getText());
			if (b >= a) {
				pickupdate.click();
				testLog.log(LogStatus.INFO, "Selected Pick Up Date is " + pickupdate.getAttribute("date-data"));
				break;
			}
		}
	}

	/**
	 * To select pickup Time in checkout page
	 * 
	 * @param pickTime
	 */
	public void selectPickUpTime(String pickTime) {
		try {
			List<WebElement> pickUpTimes = driver
					.findElements(By.cssSelector("div[class='timer-div'] span[id^='slot']"));
			for (WebElement pickupTime : pickUpTimes) {
				if (pickupTime.getText().equalsIgnoreCase(pickTime)) {
					pickupTime.click();
					testLog.log(LogStatus.INFO, "Selected Pick Up Time is " + pickTime);
					break;
				}
			}
		} catch (Exception e) {
			Assert.fail("Unable to select Pick Up time");
		}
	}

	/**
	 * To enter Coupon Code in checkout page
	 * 
	 * @param couponCode
	 * 
	 */
	public void enterCouponCode(String couponCode) {
		try {
			driver.findElement(By.cssSelector("input[id='promocode-value']")).sendKeys(couponCode);
			testLog.log(LogStatus.INFO, "Entered Coupon Code is " + couponCode);
		} catch (Exception e) {
			Assert.fail("Unable to enter Coupon Code");
		}
	}

	/**
	 * To enter Coupon Code in confirm checkout page
	 * 
	 * @param couponCode
	 * 
	 */
	public void enterCouponCodeInConfirmCheckoutPage(String couponCode) {
		try {
			driver.findElement(By.cssSelector("input[id='promocode-valueNEW']")).sendKeys(couponCode);
			testLog.log(LogStatus.INFO, "Entered Coupon Code is " + couponCode);
		} catch (Exception e) {
			Assert.fail("Unable to enter Coupon Code in Confirm Checkout Page");
		}
	}

	/**
	 * To click on Apply button
	 */
	public void clickOnApplyBtn() {
		try {
			driver.findElement(
					By.cssSelector("div[class*='apply-btn-div']>button[class='promo-submit-button apply-btn']"))
					.click();
			testLog.log(LogStatus.INFO, "Clicked on Apply button");
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail("Unable to click on Apply button");
		}
	}

	/**
	 * To get Price for required service Plan
	 */
	public double getPriceForServicePlan() {
		String servicePlanprice = driver
				.findElement(By.cssSelector("div[class='all-cart-items'] span[id^='price-enabled']")).getText();
		String pricevalue = servicePlanprice.replace("Rs.", "");
		double price = Double.parseDouble(pricevalue);
		return price;
	}

	/**
	 * To apply Discount for Coupon applied
	 * 
	 * @return 'Discount' amount
	 */
	public double applyDiscount() {
		String subTotalPrice = driver.findElement(By.cssSelector("p[class='service-price subtotal']")).getText()
				.replace("Rs.", "");
		double sTPrice = Double.parseDouble(subTotalPrice);
		double discount = sTPrice * 0.1;
		return discount;
	}

	/**
	 * To verify Total price after applying discount
	 * 
	 * @return 'Total Price'
	 */
	public boolean verifyTotalPrice() {
		boolean verify = false;
		String couponCodeMessage = null;
		String serviceTotalPrice = driver.findElement(By.cssSelector("span[class='total-price-value totalsum']"))
				.getText();
		String totalPriceValue = serviceTotalPrice.replace("Rs. ", "");
		double totalPrice = Double.parseDouble(totalPriceValue);
		String subTotalPrice = driver.findElement(By.cssSelector("p[class='service-price subtotal']")).getText()
				.replace("Rs.", "");
		double sTPrice = Double.parseDouble(subTotalPrice);
		couponCodeMessage = driver.findElement(By.cssSelector("span[class='promo-code-alert']")).getText();
		if (couponCodeMessage.equalsIgnoreCase("Coupon Applied")) {
			double totalValue = 0;
			if (applyDiscount() > 500.0) {
				totalValue = sTPrice - 750.0;
			} else {
				totalValue = sTPrice - applyDiscount();
			}
			verify = (totalPrice == totalValue) ? true : false;
		} else {
			double totalValue = getPriceForServicePlan();
			verify = (totalPrice == totalValue) ? true : false;
		}
		return verify;
	}

	/**
	 * To click on Next button
	 */
	public void clickOnNextBtn() {
		try {
			driver.findElement(By.cssSelector("button[id='confirm-btn']")).click();
			testLog.log(LogStatus.INFO, "Clicked on Next button");
		} catch (Exception e) {
			Assert.fail("Unable to click on Next button");
		}
	}

	/**
	 * This method help to enter car registration number
	 * 
	 * @param carRegistrationNumber
	 */
	public void enterCarRegistrationNumber(String carRegistrationNumber) {
		try {
			driver.findElement(By.cssSelector("input[id='car-number']")).sendKeys(carRegistrationNumber);
			testLog.log(LogStatus.INFO, "Entered Car Registration Number is " + carRegistrationNumber);
		} catch (Exception e) {
			Assert.fail("Unable to enter Car Registration number");
		}
	}

	/**
	 * To enter address
	 * 
	 * @param locationAddress
	 */
	public void enterAddress(String locationAddress) {
		try {
			driver.findElement(By.cssSelector("input[id='location-address']")).sendKeys(locationAddress);
			testLog.log(LogStatus.INFO, "Entered Address is " + locationAddress);
		} catch (Exception e) {
			Assert.fail("Unable to enter Address");
		}
	}

	/**
	 * To enter landmark
	 * 
	 * @param locationLandmark
	 */
	public void enterLandmark(String locationLandmark) {
		try {
			driver.findElement(By.cssSelector("input[id='location-landmark']")).sendKeys(locationLandmark);
			testLog.log(LogStatus.INFO, "Entered Landmark is " + locationLandmark);
		} catch (Exception e) {
			Assert.fail("Unable to enter landMark");
		}
	}

	/**
	 * To click on Confirm button
	 */
	public void clickOnConfirmBtn() {
		try {
			WebElement element = driver.findElement(
					By.cssSelector("div[class$='checkout-user-creadentials-div'] button[id='confirm-btn']"));
			JavascriptExecutor executor = (JavascriptExecutor) driver;
			executor.executeScript("arguments[0].click();", element);
			testLog.log(LogStatus.INFO, "Clicked on Confirm button");
		} catch (Exception e) {
			Assert.fail("Unable to click on Confirm button");
		}
	}

	/**
	 * To verify a service plan is booked
	 * 
	 * @return message if service plan is booked
	 */
	public String verifyServicePlanBooked() {
		return driver.findElement(By.cssSelector("div[class='inner-thankyou-padding'] h1")).getText();
	}

	/**
	 * To verify selected service plan price on 'Your Order' card
	 * 
	 * @return service plan 'Price' on Checkout page
	 */
	public String verifyServicePlanPriceOnCheckoutPage() {
		String checkOutPrice = driver
				.findElement(By.cssSelector("div[class='all-cart-items'] span[id^='price-enabled']")).getText();
		return checkOutPrice;
	}

	/**
	 * To verify selected service plan subTotal price on 'Your Order' card
	 * 
	 * @return 'SubTotal Price' on checkout page
	 */
	public String verifySubTotalPriceOnCheckoutPage() {
		String subTotalPrice = driver.findElement(By.cssSelector("p.subtotal:nth-child(2)")).getText();
		return subTotalPrice;
	}

	/**
	 * To verify selected Discount price on 'Your Order' card
	 * 
	 * @return 'Discount Price' on Checkout page
	 */
	public String verifyDiscountPriceOnCheckoutPage() {
		String subTotalPrice = driver.findElement(By.cssSelector("p[id='discount-applied']")).getText();
		return subTotalPrice;
	}

	/**
	 * To verify 'Coupon Applied' success message
	 * 
	 * @return 'message' if coupon code is applied
	 */
	public String verifyCouponCodeAppliedMessage() {
		String message = driver.findElement(By.cssSelector("span[class='promo-code-alert']")).getAttribute("innerText");
		return message;
	}

	/**
	 * To Verify User is navigated to Confirm Order page
	 * 
	 * @return 'Title' for Confirm Order page
	 */
	public String verifyUserNavigatedToConfirmOrderPage() {
		String URL = driver.getCurrentUrl();
		return URL;
	}

	/**
	 * To Verify error message on checkout page
	 * 
	 * @return 'Alert message'
	 */
	public String verifyAlertErrorMessage() {
		String message = driver.findElement(By.cssSelector("div.floating-alert>p#alert-text")).getText()
				.replaceAll("\\r\\n|\\r|\\n", "");
		String errorMessage = message.replaceAll("  ", " ");
		return errorMessage;
	}

	/**
	 * To clear Coupon code from 'Have a coupon?' field
	 * 
	 * @param cuponCode
	 */
	public void removeCouponCode() {
		try {
			driver.findElement(By.cssSelector("input[id='promocode-value']")).clear();
			testLog.log(LogStatus.INFO, "Removed coupon code from 'Have a coupon?' field");
		} catch (Exception e) {
			Assert.fail("Unable to removed coupon code from 'Have a coupon?' field");
		}
	}

	/**
	 * To clear Coupon code from 'Have a coupon?' field in confirm checkout
	 * 
	 * @param cuponCode
	 */
	public void removeCouponCodeInConfirmCheckoutPage() {
		try {
			driver.findElement(By.cssSelector("input[id='promocode-valueNEW']")).clear();
			testLog.log(LogStatus.INFO, "Removed coupon code from 'Have a coupon?' field");
		} catch (Exception e) {
			Assert.fail("Unable to removed coupon code from 'Have a coupon?' field in Confirm Checkout page");
		}
	}

	/**
	 * To get Discount applied amount on Your Order modal
	 * 
	 * @return Discount amount
	 */
	public String getDiscoutnAppliedAmount() {
		return driver.findElement(By.cssSelector("div.order-summary-div>div.service>div>p#discount-applied")).getText();
	}

	/**
	 * To get Total price amount on Your Order modal
	 * 
	 * @return Total price on Order model
	 */
	public String getTotalPriceOnYourOrderModal() {
		return driver.findElement(By.cssSelector("div.total-price>div>span[class*='totalsum']")).getText()
				.replaceAll(" ", "");
	}

	/**
	 * To verify selected plans price with Total price on 'Your Order' card
	 * 
	 * @return 'Total price' for selected plan
	 */
//	public boolean verifySelectedPlansPriceWithTotalPrice() {
//		List<WebElement> plansPrices = driver.findElements(By.cssSelector(
//				"div[class*='order-summary']>div.all-cart-items>div.service>div>span[id*='price-enabled']"));
//		float sum = 0;
//		for (WebElement price : plansPrices) {
//			String p = price.getText().replace("Rs.", "");
//			float fP = Float.parseFloat(p);
//			sum = sum + fP;
//		}
//		String totalPrice = driver.findElement(By.cssSelector("span[class='total-price-value totalsum']")).getText()
//				.replace("Rs. ", "");
//		float flaotTotalPrice = Float.parseFloat(totalPrice);
//		Predicate<Float> p = i -> i == flaotTotalPrice;
//		return p.test(sum);
//	}
}
