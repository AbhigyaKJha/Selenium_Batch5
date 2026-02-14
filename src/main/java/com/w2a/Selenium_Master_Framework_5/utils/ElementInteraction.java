package com.w2a.Selenium_Master_Framework_5.utils;

import org.openqa.selenium.By;

import com.w2a.Selenium_Master_Framework_5.testSetUp.TestSetup;

public class ElementInteraction extends TestSetup {

	public static void type(By locator, String value) {
		driver.findElement(locator).sendKeys(value);
	}

	public static void click(By locator) {
		driver.findElement(locator).click();

	}

	public static void clear(By locator) {
		driver.findElement(locator).clear();
	}

	public static String getElementText(By locator) {
		return driver.findElement(locator).getText();
	}

	// method to check if element is displayed or not
	public static boolean isElementDisplayed(By locator) {
		try {
			WaitMachine.waitForElementToBeDisplayed(locator);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// method to check if element is enabled or not

	public static boolean isElementEnabled(By locator) {
		return driver.findElement(locator).isEnabled();
	}

	// method to check if element is selected or not
	public static boolean isElementSelected(By locator) {
		return driver.findElement(locator).isSelected();
		//TODO: Handle this using WaitMachine
	}

	// method to check if element is clickable or not
	public static boolean isElementClickable(By locator) {
		try {
			driver.findElement(locator).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
