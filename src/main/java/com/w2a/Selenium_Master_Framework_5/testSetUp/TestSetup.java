package com.w2a.Selenium_Master_Framework_5.testSetUp;

import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.aventstack.extentreports.ExtentReports;
import com.w2a.Selenium_Master_Framework_5.utils.ApplicationConstants;
import com.w2a.Selenium_Master_Framework_5.utils.DriverManager;
import com.w2a.Selenium_Master_Framework_5.utils.ExcelReader;
import com.w2a.Selenium_Master_Framework_5.utils.ExtentReportManager;
import com.w2a.Selenium_Master_Framework_5.utils.PropertyFilemanager;

public class TestSetup {

	protected static Properties prop;
	protected static WebDriver driver;
	public static ExtentReports extent;
	public static ExcelReader excel = new ExcelReader(ApplicationConstants.TestData_SHEET_PATH + "TestCaseData.xlsx");

	// Before Suite
	@Parameters("env")
	@BeforeSuite
	public synchronized void testSetup(String env) {

		prop = PropertyFilemanager.initializePropertyFile(env);
		extent = ExtentReportManager.initializeExtentReport();
		System.out.println(extent);

	}

	// Before Test

	// before Method
	@Parameters("browser")
	@BeforeMethod
	public void beforeMethod(Method method, String browser) {
		DriverManager.initDriver(browser);
		DriverManager.navigateToTestSite(prop.getProperty("testURL"), DriverManager.getDriver());
		// ExtentReportManager.createExtentTest(method.getName());
		// System.out.println("**** Execution of Test Case: " + method.getName() + "
		// Started ****");

	}

	// After Method
	@AfterMethod
	public void afterMethod(ITestResult result) {

		/*
		 * if(result.getStatus()== result.SUCCESS) {
		 * System.out.println("**** Execution of Test Case: " + result.getName() +
		 * " Passed ****"); }else if(result.getStatus()== result.FAILURE) {
		 * System.out.println("**** Execution of Test Case: " + result.getName() +
		 * " Failed ****"); } else if(result.getStatus()==result.SKIP) {
		 * System.out.println("**** Execution of Test Case: " + result.getName() +
		 * " Skipped ****"); }
		 */
		DriverManager.killDriver(DriverManager.getDriver());

	}
	// After Test

	// After Suite

}
