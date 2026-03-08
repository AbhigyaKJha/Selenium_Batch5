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

	private static ThreadLocal<WebDriver> driver= new ThreadLocal<WebDriver>();

	public synchronized static WebDriver initDriver(String browserName) {
		if (browserName.equalsIgnoreCase(ApplicationConstants.CHROME_BROWSER)) {
			DriverManager.setDriver(new ChromeDriver(BrowserOptions.getChromeOptions()));
			// ChromeOptions

		} else if (browserName.equalsIgnoreCase(ApplicationConstants.FIREFOX_BROWSER)) {
			DriverManager.setDriver(new FirefoxDriver());
			// FirefoxOptions

		} else if (browserName.equalsIgnoreCase(ApplicationConstants.SAFARI_BROWSER)) {
			DriverManager.setDriver( new SafariDriver());
			// SafariOptions

		}
		maximizeBrowser();
		applyImplicitWait();
		return DriverManager.getDriver();
	}
	
	public static WebDriver getDriver() {
		return DriverManager.driver.get();
	}
	
	public static void setDriver(WebDriver driver) {
		DriverManager.driver.set(driver);
	}

	private static void maximizeBrowser() {
		DriverManager.getDriver().manage().window().maximize();
	}

	private static void applyImplicitWait() {
		DriverManager.getDriver().manage().timeouts().implicitlyWait(Duration.ofSeconds(ApplicationConstants.DEFAULT_WAIT_TIMEOUT));
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
