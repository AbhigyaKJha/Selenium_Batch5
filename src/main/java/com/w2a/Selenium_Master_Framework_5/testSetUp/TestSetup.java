package com.w2a.Selenium_Master_Framework_5.testSetUp;

import java.lang.reflect.Method;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.ITestResult;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.Parameters;

import com.w2a.Selenium_Master_Framework_5.utils.DriverManager;
import com.w2a.Selenium_Master_Framework_5.utils.PropertyFilemanager;

public class TestSetup {

	protected static Properties prop;
	protected static WebDriver driver;

	// Before Suite
	@Parameters("env")
	@BeforeSuite
	public void testSetup(String env) {
		// Initialize PropertyFile
		prop = PropertyFilemanager.initializePropertyFile(env);
		// Initialize logger
		// initialize Reporter

	}

	// Before Test

	// before Method
	@BeforeMethod
	public void beforeMethod(Method method) {
		driver = DriverManager.initDriver("chrome");
		DriverManager.navigateToTestSite(prop.getProperty("testURL"), driver);
		//System.out.println("**** Execution of Test Case: " + method.getName() + " Started ****");

	}

	// After Method
	@AfterMethod
	public void afterMethod(ITestResult result) {
		
		/*if(result.getStatus()== result.SUCCESS)
		{
			System.out.println("**** Execution of Test Case: " + result.getName() + " Passed ****");
		}else if(result.getStatus()== result.FAILURE)
		{
			System.out.println("**** Execution of Test Case: " + result.getName() + " Failed ****");
		}
		else if(result.getStatus()==result.SKIP)
		{
			System.out.println("**** Execution of Test Case: " + result.getName() + " Skipped ****");
		}*/
		DriverManager.killDriver(driver);

	}
	// After Test

	// After Suite

}
