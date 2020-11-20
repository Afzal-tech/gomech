package com.gomechanic.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.testng.Assert;

import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class CartPage {

	private WebDriver driver;
	private ExtentTest testLog;

	public CartPage(WebDriver driver, ExtentTest testLog) {
		this.driver = driver;
		this.testLog = testLog;
	}

	/**
	 * To click on Proceed To CheckOut button
	 * 
	 * @return To Checkout Page
	 */
	public CheckOutPage clickOnProceedToCheckOut() {
		try {
			driver.findElement(By.cssSelector("div[class$='show-cart-btn-section'] p[id='find-service-text-cart']"))
					.click();
			testLog.log(LogStatus.INFO, "Clicked on Proceed To CheckOut button");
		} catch (Exception e) {
			Assert.fail("Unable to click on Proceed To CheckOut button");
		}
		return new CheckOutPage(driver, testLog);
	}

	/**
	 * To Verify 'Basic Service' plan added to the Cart or not
	 * 
	 * @throws InterruptedException
	 */
	public String verifyBasicServicePlanAddedToCart() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String planName = driver.findElement(By.cssSelector(
				"div[class='col-sm-12 heading-padding-remove all-cart-items']>div:nth-child(1)>div>div:nth-child(2)"))
				.getText();
		return planName;
	}

	/**
	 * To verify Basic service plan price on Cart
	 * 
	 * @return 'Price' of basic service plan added on cart
	 */
	public String verifyBasicServicePlanPriceOnCart() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String price = driver.findElement(By.cssSelector(
				"div[class='col-sm-12 heading-padding-remove all-cart-items']>div:nth-child(1)>div:nth-child(2)"))
				.getText();
		return price;
	}

	/**
	 * To Verify selected service plan added to the Cart or not
	 * 
	 * @throws InterruptedException
	 */
	public String verifySelectedServicePlanAddedToCart() {
		try {
			Thread.sleep(3000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String planName = driver.findElement(By.cssSelector(
				"div[class='col-sm-12 heading-padding-remove all-cart-items']>div:nth-child(1)>div>div:nth-child(2)"))
				.getText();
		return planName;
	}

	/**
	 * To verify selected service plan price on Cart
	 * 
	 * @return 'Price' for any selected service plan that added on cart
	 * @throws InterruptedException
	 */
	public String verifySelectedServicePlanPriceOnCart() {
		try {
			Thread.sleep(2000);
		} catch (InterruptedException e) {
			e.printStackTrace();
		}
		String price = driver.findElement(By.cssSelector(
				"div[class='col-sm-12 heading-padding-remove all-cart-items']>div:nth-child(1)>div:nth-child(2)"))
				.getText();
		return price;
	}

	/**
	 * To verify user is navigated to checkout page or not
	 * 
	 * @return 'Title' of Checkout Page
	 */
	public String verifyUserNavigateToCheckoutPage() {
		String pageTitle = driver.getTitle();
		return pageTitle;
	}

	/**
	 * To verify selected multiple service plans added to cart
	 * 
	 * @return 'Service plan' name for added service plan in cart
	 * @throws InterruptedException
	 */
	public String verifySelectedMultipleServicePlansAddedToCart(int count) throws InterruptedException {
		Thread.sleep(2000);
		String planName = "";
		List<WebElement> plansCount = driver.findElements(By.cssSelector(
				"div[class*='all-cart-items']>div>div[class*='top remove-items-name-container']>div:nth-child(2)"));
		if (plansCount.size() > 1) {
			planName = plansCount.get(count).getText();
		}
		return planName;
	}

	/**
	 * To verify selected multiple service plans prices on cart
	 * 
	 * @return Service plan Price for added Service Plan Price in Cart
	 * @throws InterruptedException
	 */
	public String verifySelectedMultipleServicePlansPriceDetailsCart(int count) throws InterruptedException {
		Thread.sleep(2000);
		String planPrice = "";
		List<WebElement> plansPricesCount = driver
				.findElements(By.cssSelector("div[class*='all-cart-items']>div>div:nth-child(2)"));
		if (plansPricesCount.size() > 1) {
			planPrice = plansPricesCount.get(count).getText();
		}
		return planPrice;
	}

	/**
	 * To close Cart modal dialog box
	 * 
	 * @throws InterruptedException
	 */
	public void clickOnCartCloseIcon() throws InterruptedException {
		try {
			driver.findElement(By.cssSelector("p[class*='cart-heading']>button.close")).click();
			Thread.sleep(3000);
			testLog.log(LogStatus.INFO, "Clicked on Close icon on Cart modal");
		} catch (Exception e) {
			Assert.fail("Unable to click on Close icon on Cart modal");
		}
	}

	/**
	 * To enter Coupon code in the 'Enter Coupon Code' field on Cart
	 * 
	 * @param couponCode
	 */
	public void enterCouponCodeOnCart(String couponCode) {
		try {
			driver.findElement(By.cssSelector("input.input-promo")).sendKeys(couponCode);
			testLog.log(LogStatus.INFO, "Entered coupon code on cart is: " + couponCode);
		} catch (Exception e) {
			Assert.fail("Unable to enter coupon code on cart");
		}
	}

	/**
	 * To verify Coupon Applied message on Cart page
	 * 
	 * @return message if coupon is applied
	 */
	public String verifyCouponAppliedMessageOnCart() {
		return driver.findElement(By.cssSelector("div[class*='right-align']>span")).getText();
	}

	/**
	 * To verify Discount Applied amount on Cart
	 * 
	 * @return 'Discount' amount for services added service to cart
	 * @throws InterruptedException
	 */
	public boolean verifyDiscoutnAppliedAmountOnCart() throws InterruptedException {
		boolean verify = false;
		String discountAmountOnCart = driver.findElement(By.cssSelector("p#discount-applied-modal")).getText()
				.replace("Rs.", "");
		float amountOnCart = Float.parseFloat(discountAmountOnCart);
		if (calculateDiscountAmount() > 500) {
			verify = amountOnCart == 750.0;
		} else {
			verify = amountOnCart == calculateDiscountAmount();
		}
		return verify;
	}

	/**
	 * To calculate discount amount
	 * 
	 * @return Discount amount
	 * @throws InterruptedException
	 */
	public float calculateDiscountAmount() throws InterruptedException {
		String priceValue = verifySelectedServicePlanPriceOnCart().replace("Rs.", "");
		float price = Float.parseFloat(priceValue);
		float calDiscount = (float) (price * 0.1);
		if (calDiscount > 500.0) {
			calDiscount = 750;
		}
		return calDiscount;
	}

	/**
	 * To verify Total price on Cart after applying coupon code
	 * 
	 * @return Total Price
	 * @throws InterruptedException
	 */
	public boolean verifyTotalPriceOnCart() throws InterruptedException {
		String serviceTotalPrice = driver.findElement(By.cssSelector("p[class='float-right totalsum']")).getText()
				.replace("Rs.", "");
		double totalPrice = Double.parseDouble(serviceTotalPrice);
		String servicePlanPrice = verifySelectedServicePlanPriceOnCart().replace("Rs.", "");
		float planPrice = Float.parseFloat(servicePlanPrice);
		boolean verify = false;
		if (calculateDiscountAmount() != 0) {
			float totalValue = planPrice - calculateDiscountAmount();
			verify = (totalPrice == totalValue) ? true : false;
		} else
			return true;

		return verify;
	}

	/**
	 * To click on Apply button on cart
	 */
	public void clickOnApplyButtonOnCart() {
		try {
			driver.findElement(By.cssSelector("input#submit-promo-modal")).click();
			testLog.log(LogStatus.INFO, "Clicked on Apply button");
			Thread.sleep(3000);
		} catch (Exception e) {
			Assert.fail("Unable to Click on Apply button");
		}
	}

	/**
	 * To click on Remove icon from Cart
	 * 
	 * @return to Home page
	 */
	public HomePage clicKOnRemoveIcon() {
		try {
			driver.findElement(By.cssSelector("img[class='remove-cart-svg']")).click();
			testLog.log(LogStatus.INFO, "Clicked on Remove icon");
		} catch (Exception e) {
			Assert.fail("Unable to Click on Remove icon");
		}
		return new HomePage(driver, testLog);
	}

	/**
	 * To verify Coupon Applied message on Cart page
	 * 
	 * @return message on cart
	 */
	public String verifyErrorMessageOnCart() {
		return driver.findElement(By.cssSelector("div[class*='right-align']>span")).getText();
	}
}
