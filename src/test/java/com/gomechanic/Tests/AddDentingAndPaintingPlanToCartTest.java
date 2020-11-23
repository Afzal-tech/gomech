package com.gomechanic.Tests;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gomechanic.baseclass.BaseTestSuite;
import com.gomechanic.pages.CarDetailsPage;
import com.gomechanic.pages.DentingAndPaintingPage;
import com.gomechanic.pages.HomePage;
import com.gomechanic.pages.PlaceOrder;
import com.gomechanic.pages.SelectCityPage;
import com.relevantcodes.extentreports.LogStatus;

public class AddDentingAndPaintingPlanToCartTest extends BaseTestSuite{

	@Test(description="Validate user is able to select 'Full Body Dent Paint' from 'Denting & Painting Services'")
	public void selectDentingAndPaintingPlan(Method method) throws InterruptedException {
	
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
			Thread.sleep(11000);
			detailsPage.clickLiveChatCrossBtn();
			Thread.sleep(3000);
			detailsPage.enterMobileNumber(data1[0][4]);
			detailsPage.clickOnCheckPriceBtn();
			Thread.sleep(8000);
		   	String[][] data2 = excelData.readData("DentingPaintingPlans");
		   	DentingAndPaintingPage dentingAndPaintingPage=new DentingAndPaintingPage(driver, testLog);
		   	dentingAndPaintingPage.selectDentingAndPaintingService();
			Assert.assertEquals(data2[0][0], dentingAndPaintingPage.verifyDentingAndPaintingServiceMenuBarText());
			testLog.log(LogStatus.INFO, "Expected Denting&Painting Service Menu Tab Text: '" + data2[0][0] + "' is verified with Actual: '"
					+ dentingAndPaintingPage.verifyDentingAndPaintingServiceMenuBarText() + "'");
			Assert.assertEquals(data2[0][1], dentingAndPaintingPage.verifyHeaderText());
			testLog.log(LogStatus.INFO, "Expected 'Whole Body' Header Text from 'Denting&Painting Service': '" + data2[0][1] + "' is verified with Actual: '"
					+ dentingAndPaintingPage.verifyHeaderText() + "'");
			Assert.assertEquals(data2[0][2], dentingAndPaintingPage.verifyServiceNameText());
			testLog.log(LogStatus.INFO, "Expected 'Full Body Dent Paint' Service Name 'Denting&Painting Service': '" + data2[0][2] + "' is verified with Actual: '"
					+ dentingAndPaintingPage.verifyServiceNameText() + "'");
			dentingAndPaintingPage.clickAddToCart();
			Assert.assertEquals(data2[0][2], dentingAndPaintingPage.verifyAddOn());
			testLog.log(LogStatus.INFO, "Expected 'Add Addon': '" + data2[0][2] + "' is verified with Actual: '"
					+ dentingAndPaintingPage.verifyAddOn() + "'");
			dentingAndPaintingPage.clickAddBtn();
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
