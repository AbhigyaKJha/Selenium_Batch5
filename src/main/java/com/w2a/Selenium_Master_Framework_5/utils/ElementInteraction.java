package com.w2a.Selenium_Master_Framework_5.utils;

import org.openqa.selenium.By;
import org.openqa.selenium.WebElement;

import com.w2a.Selenium_Master_Framework_5.testSetUp.TestSetup;

public class ElementInteraction extends TestSetup {
	
	public synchronized static WebElement getElement(By locator) {
		return DriverManager.getDriver().findElement(locator);
	}

	public synchronized static void type(By locator, String value) {
		DriverManager.getDriver().findElement(locator).sendKeys(value);
	}
	
	public synchronized static void type(By locator, String value, String elementName) {
		DriverManager.getDriver().findElement(locator).sendKeys(value);
		ExtentReportManager.getExtentTest().info("Entered value: "+"<b>"+value+"</b>" +" in element: "+"<b><i>"+elementName.toUpperCase()+"</i></b>");
	}

	public synchronized static void click(By locator) {
		DriverManager.getDriver().findElement(locator).click();

	}
	
	public synchronized static void click(By locator,String elementName) {
		DriverManager.getDriver().findElement(locator).click();
		ExtentReportManager.getExtentTest().info("Clicked on element: "+elementName.toUpperCase());

	}

	public synchronized static void clear(By locator) {
		DriverManager.getDriver().findElement(locator).clear();
	}

	public synchronized static String getElementText(By locator) {
		return DriverManager.getDriver().findElement(locator).getText();
	}

	// method to check if element is displayed or not
	public synchronized static boolean isElementDisplayed(By locator) {
		try {
			WaitMachine.waitForElementToBeDisplayed(locator);
			return true;
		} catch (Exception e) {
			return false;
		}
	}

	// method to check if element is enabled or not

	public synchronized static boolean isElementEnabled(By locator) {
		return DriverManager.getDriver().findElement(locator).isEnabled();
	}

	// method to check if element is selected or not
	public synchronized static boolean isElementSelected(By locator) {
		return DriverManager.getDriver().findElement(locator).isSelected();
		//TODO: Handle this using WaitMachine
	}

	// method to check if element is clickable or not
	public synchronized static boolean isElementClickable(By locator) {
		try {
			DriverManager.getDriver().findElement(locator).click();
			return true;
		} catch (Exception e) {
			return false;
		}
	}

}
