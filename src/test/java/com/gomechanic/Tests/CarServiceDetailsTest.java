package com.gomechanic.Tests;

import static org.testng.Assert.assertEquals;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.gomechanic.baseclass.BaseTestSuite;
import com.gomechanic.pages.CarDetailsPage;
import com.gomechanic.pages.HomePage;
import com.gomechanic.pages.SelectCityPage;
import com.relevantcodes.extentreports.LogStatus;

public class CarServiceDetailsTest extends BaseTestSuite{

	@Test(description="Validate user is able to select 'Car Details'")
	public void selectBasicServicePlan(Method method) {
		testLog = extent.startTest(this.getClass().getSimpleName(), method.getAnnotation(Test.class).description());
        String[][] data = excelData.readData("Checkout");
		
		SelectCityPage selectCity = new SelectCityPage(driver, testLog);

		HomePage homePage = selectCity.selectRequiredCity(data[0][0]);
		assertEquals(data[0][0], selectCity.validateSelectedCity());
		selectCity.clickOnCityName(data[0][0]);
		testLog.log(LogStatus.INFO, "Verified with selected city name " + data[0][0]);
		CarDetailsPage detailsPage = homePage.clickOnServicesTab();
		detailsPage.selectRequiredCarBrand(data[0][1]);
		try {
			Thread.sleep(6000);
		} catch (InterruptedException e) {
			// TODO Auto-generated catch block
			//e.printStackTrace();
		}
		detailsPage.selectRequiredCarModel(data[0][2]);
		detailsPage.selectRequiredFuel(data[0][3]);
			assertEquals(data[0][1], detailsPage.validateCarBrand());
			testLog.log(LogStatus.INFO, "Expected car brand name: '" + data[0][1] + "' is verified with Actual: '"
					+ detailsPage.validateCarBrand() + "'");
			assertEquals(data[0][2], detailsPage.validateCarModel());
			testLog.log(LogStatus.INFO, "Expected car model name: '" + data[0][2] + "' is verified with Actual: '"
					+ detailsPage.validateCarModel() + "'");
			assertEquals(data[0][3], detailsPage.validateCarFuelType());
			testLog.log(LogStatus.INFO, "Expected car Fuel Type name: '" + data[0][3] + "' is verified with Actual: '"
					+ detailsPage.validateCarFuelType() + "'");
			detailsPage.enterMobileNumber(data[0][4]);
			detailsPage.clickOnCheckPriceBtn();
	}

}
