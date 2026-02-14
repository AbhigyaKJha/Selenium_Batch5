package com.w2a.Selenium_Master_Framework_5.utils;

import java.time.Duration;

import org.openqa.selenium.By;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class WaitMachine {

	private static WebDriverWait wait = new WebDriverWait(DriverManager.getDriver(),
			Duration.ofSeconds(ApplicationConstants.DEFAULT_WAIT_TIMEOUT));
	
	//wait for element to be present
	public static void waitForElementToBePresent(By locator) {
		wait.until(ExpectedConditions.presenceOfElementLocated(locator));
	}
	
	//wait for element to be displayed
	public static void waitForElementToBeDisplayed(By locator) {
		wait.until(ExpectedConditions.visibilityOfElementLocated(locator));
	}
	
	
	//wait for element to be clickable
	public static void waitForElementToBeClickable(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	//wait for element to be enabled
	public static void waitForElementToBeEnabled(By locator) {
		wait.until(ExpectedConditions.elementToBeClickable(locator));
	}
	
	
	
	

}
