package com.w2a.Selenium_Master_Framework_5.testSetUp;

import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;

import com.w2a.Selenium_Master_Framework_5.utils.DriverManager;
import com.w2a.Selenium_Master_Framework_5.utils.PropertyFilemanager;

public class TestSetup {

	protected static Properties prop;
	protected static WebDriver driver;

	// Before Suite
	@BeforeSuite
	public void testSetup() {
		// Initialize PropertyFile
		prop = PropertyFilemanager.initializePropertyFile();
		// Initialize logger
		// initialize Reporter

	}

	// Before Test

	// before Method
	@BeforeMethod
	public void beforeMethod() {
		driver = DriverManager.initDriver("chrome");
		DriverManager.navigateToTestSite(prop.getProperty("testURL"), driver);

	}

	// After Method
	@AfterMethod
	public void afterMethod() {
		DriverManager.killDriver(driver);

	}
	// After Test

	// After Suite

}
