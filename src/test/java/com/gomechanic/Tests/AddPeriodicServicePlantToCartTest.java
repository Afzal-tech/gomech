package com.gomechanic.Tests;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gomechanic.baseclass.BaseTestSuite;
import com.gomechanic.pages.CarDetailsPage;
import com.gomechanic.pages.HomePage;
import com.gomechanic.pages.PeriodicServicePage;
import com.gomechanic.pages.PlaceOrder;
import com.gomechanic.pages.SelectCityPage;
import com.relevantcodes.extentreports.LogStatus;

public class AddPeriodicServicePlantToCartTest extends BaseTestSuite{
	@Test(description="Validate user is able to select 'Basic Service' from 'Periodic Service'")
	public void selectBasicServicePlan(Method method) throws InterruptedException {
		testLog = extent.startTest(this.getClass().getSimpleName(), method.getAnnotation(Test.class).description());
        String[][] data1 = excelData.readData("Checkout");
		SelectCityPage selectCity = new SelectCityPage(driver, testLog);
		PlaceOrder PlaceOrder=new PlaceOrder(driver, testLog);
		HomePage homePage = selectCity.selectRequiredCity(data1[0][0]);
		assertEquals(data1[0][0], selectCity.validateSelectedCity());
		selectCity.clickOnCityName(data1[0][0]);
		testLog.log(LogStatus.INFO, "Verified with selected city name " + data1[0][0]);
		CarDetailsPage detailsPage = homePage.clickOnServicesTab();
		detailsPage.selectRequiredCarBrand(data1[0][1]);
			Thread.sleep(6000);
		detailsPage.selectRequiredCarModel(data1[0][2]);
		detailsPage.selectRequiredFuel(data1[0][3]);
			assertEquals(data1[0][1], detailsPage.validateCarBrand());
			testLog.log(LogStatus.INFO, "Expected car brand name: '" + data1[0][1] + "' is verified with Actual: '"
					+ detailsPage.validateCarBrand() + "'");
			assertEquals(data1[0][2], detailsPage.validateCarModel());
			testLog.log(LogStatus.INFO, "Expected car model name: '" + data1[0][2] + "' is verified with Actual: '"
					+ detailsPage.validateCarModel() + "'");
			assertEquals(data1[0][3], detailsPage.validateCarFuelType());
			testLog.log(LogStatus.INFO, "Expected car Fuel Type name: '" + data1[0][3] + "' is verified with Actual: '"
					+ detailsPage.validateCarFuelType() + "'");
			detailsPage.enterMobileNumber(data1[0][4]);
			detailsPage.clickOnCheckPriceBtn();
				Thread.sleep(12000);
	   	String[][] data2 = excelData.readData("Periodic Service");
		PeriodicServicePage periodicServicePage=new PeriodicServicePage(driver, testLog);
		Assert.assertEquals(data2[0][0], periodicServicePage.verifyBasicServiceHeaderTitle());
		testLog.log(LogStatus.INFO, "Expected Periodic Service HeaderText: '" + data1[0][0] + "' is verified with Actual: '"
				+ periodicServicePage.verifyBasicServiceHeaderTitle() + "'");
		Assert.assertEquals(data2[0][1], periodicServicePage.verifyBasicService());
		testLog.log(LogStatus.INFO, "Expected 'Basic Service' Name from 'Periodic Service': '" + data1[0][1] + "' is verified with Actual: '"
				+ periodicServicePage.verifyBasicService() + "'");
		periodicServicePage.addBasicService(data2[0][1]);
			Thread.sleep(5000);
		periodicServicePage.checkCheckBoxBoosters();
			Thread.sleep(3000);
		periodicServicePage.clickAddBoosterBtn();
		Thread.sleep(3000);
		PlaceOrder.clickOnProceedToCheckOut();
		Thread.sleep(3000);
		PlaceOrder.clickContinueBtnAccount();
		Thread.sleep(3000);
		PlaceOrder.enterOtpAccount();
		Thread.sleep(3000);
		PlaceOrder.clickVerifyOtpBtn();
		Thread.sleep(3000);
		PlaceOrder.selectDate();
		Thread.sleep(3000);
		PlaceOrder.selectTimeSlot();
		Thread.sleep(3000);
		PlaceOrder.clickContinueBtn();
		Thread.sleep(3000);
		PlaceOrder.selectAddress();
		Thread.sleep(3000);
		//PlaceOrder.clickContinueBtnAdd();
		//Thread.sleep(3000);
		PlaceOrder.clickPaymentCod();
		Thread.sleep(3000);
		PlaceOrder.clickPlaceOrder();
    	}
	}
