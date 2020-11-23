package com.gomechanic.Tests;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.gomechanic.baseclass.BaseTestSuite;
import com.gomechanic.pages.CarDetailsPage;
import com.gomechanic.pages.DetailingServicesPage;
import com.gomechanic.pages.HomePage;
import com.gomechanic.pages.PlaceOrder;
import com.gomechanic.pages.SelectCityPage;
import com.relevantcodes.extentreports.LogStatus;

public class AddDetailingServicesPlanToCartTest extends BaseTestSuite{

	@Test(description="Validate user is able to select 'PPF - Paint Protection Film' from 'Detailing Services Services'")
	public void selectTyresAndWheelCarePlan(Method method) throws InterruptedException {
	
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
		   	String[][] data2 = excelData.readData("DetailingServices");
		   	DetailingServicesPage detailingServicesPage=new DetailingServicesPage(driver, testLog);
		   	detailingServicesPage.clickScrollMenuBarRight();
		   	detailingServicesPage.selectDetailingService();
			Assert.assertEquals(data2[0][0], detailingServicesPage.verifyDetailingServiceMenuBarText());
			testLog.log(LogStatus.INFO, "Expected Detailing Service Menu Tab Text: '" + data2[0][0] + "' is verified with Actual: '"
					+ detailingServicesPage.verifyDetailingServiceMenuBarText() + "'");
			Assert.assertEquals(data2[0][1], detailingServicesPage.verifyHeaderText());
			testLog.log(LogStatus.INFO, "Expected 'Detailing & Coatings ' Header Text from 'Detailing Service': '" + data2[0][1] + "' is verified with Actual: '"
					+ detailingServicesPage.verifyHeaderText() + "'");
			Assert.assertEquals(data2[0][2], detailingServicesPage.verifyServiceNameText());
			testLog.log(LogStatus.INFO, "Expected 'PPF - Paint Protection Film' Service Name 'Detailing Service': '" + data2[0][2] + "' is verified with Actual: '"
					+ detailingServicesPage.verifyServiceNameText() + "'");
			detailingServicesPage.clickAddToCart();
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
