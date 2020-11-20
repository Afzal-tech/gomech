package com.gomechanic.baseclass;

import java.io.File;
import java.io.IOException;
import java.lang.reflect.Method;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.UUID;
import java.util.concurrent.TimeUnit;

import org.apache.commons.io.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.gomechanic.driver.DriverManagerFactory;
import com.gomechanic.driver.DriverTypes;
import com.gomechanic.utils.ConfigFileReader;
import com.gomechanic.utils.ExcelHandler;
import com.relevantcodes.extentreports.ExtentReports;
import com.relevantcodes.extentreports.ExtentTest;
import com.relevantcodes.extentreports.LogStatus;

public class BaseTestSuite {

	public com.gomechanic.driver.DriverManager driverManager;
	public WebDriver driver;
	public String timeStamp;
	public static ExcelHandler excelData;
	public static ConfigFileReader config;
	public static ExtentReports extent;
	public static ExtentTest testLog;

	@BeforeSuite
	public void beforeSuite() {
		config = new ConfigFileReader();
		timeStamp = new SimpleDateFormat("MM-dd.HH.mm.ss").format(new Date());
		extent = new ExtentReports(config.getKey("extentReport") + timeStamp + ".html", true);
		excelData = new ExcelHandler(config.getKey("testdata"));
	}

	@BeforeMethod
	public void beforeEveryTestStarts() {
		driverManager = DriverManagerFactory.getManager(DriverTypes.Chrome);
		driver = driverManager.getDriver();
		try {
			driver.manage().timeouts().implicitlyWait(Long.parseLong(config.getKey("implicitWait")), TimeUnit.SECONDS);
			driver.manage().deleteAllCookies();
			driver.get(config.getKey("url"));

		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	@AfterMethod(alwaysRun = true)
	public void afterEveryTestEnds(ITestResult result, Method method) {
		if (result.getStatus() == ITestResult.SUCCESS) {
			String image = testLog.addScreenCapture(createScreenshot());
			testLog.log(LogStatus.PASS, result.getName(), method.getName() + image);
		} else if (result.getStatus() == ITestResult.FAILURE) {
			String image = testLog.addScreenCapture(createScreenshot());
			testLog.log(LogStatus.FAIL, result.getThrowable());
			testLog.log(LogStatus.FAIL, result.getName(), method.getName() + image);
		} else {
			testLog.log(LogStatus.SKIP, result.getName(), method.getName());
			testLog.log(LogStatus.FAIL, result.getThrowable());
		}
		extent.endTest(testLog);
		extent.flush();
		driver.quit();
	}

	public String createScreenshot() {
		UUID uuid = UUID.randomUUID();
		File scrFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
		try {
			FileUtils.copyFile(scrFile, new File(config.getKey("screenshotLocation") + uuid + ".png"));
		} catch (IOException e) {
			testLog.log(LogStatus.INFO, "Error while generating screenshot:\n" + e.toString());
		}
		return "./Screenshots/" + uuid + ".png";
	}
}
