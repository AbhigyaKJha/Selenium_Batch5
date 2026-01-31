package com.w2a.Selenium_Master_Framework_5.utils;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.safari.SafariDriver;

public class DriverManager {
	/*
	 * This class will be responsible for managing Browser Driver related stuff
	 */

	private static WebDriver driver;

	public static WebDriver initDriver(String browserName) {
		if (browserName.equalsIgnoreCase(ApplicationConstants.CHROME_BROWSER)) {
			driver = new ChromeDriver();
			// ChromeOptions

		} else if (browserName.equalsIgnoreCase(ApplicationConstants.FIREFOX_BROWSER)) {
			driver = new FirefoxDriver();
			// FirefoxOptions

		} else if (browserName.equalsIgnoreCase(ApplicationConstants.SAFARI_BROWSER)) {
			driver = new SafariDriver();
			// SafariOptions

		}
		maximizeBrowser();
		applyImplicitWait();
		return driver;
	}

	private static void maximizeBrowser() {
		driver.manage().window().maximize();
	}

	private static void applyImplicitWait() {
		driver.manage().timeouts().implicitlyWait(Duration.ofSeconds(ApplicationConstants.DEFAULT_WAIT_TIMEOUT));
	}

	public static void killDriver(WebDriver driver) {
		if (driver != null) {
			driver.quit();
		}
	}

	public static void closeDriver(WebDriver driver) {
		if (driver != null) {
			driver.close();
		}
	}

	public static void navigateToTestSite(String testSiteURL, WebDriver driver) {
		driver.get(testSiteURL);

	}

}
