package com.w2a.Selenium_Master_Framework_5.testCases;

import java.time.Duration;

import org.openqa.selenium.By;
import org.testng.annotations.Test;

import com.w2a.Selenium_Master_Framework_5.testSetUp.TestSetup;

public class SwagLabsLoginTest extends TestSetup {

	@Test
	public void verifyloginWithValidCredentials() throws InterruptedException {
		// Launch A Browser -> Handled in TestSetup class

		// Navigate to Test Site URL-> Handled in TestSetup class

		// Enter Valid UserName
		driver.findElement(By.id("user-name")).sendKeys(prop.getProperty("adminUserName"));

		// Enter Valid Password
		driver.findElement(By.id("password")).sendKeys(prop.getProperty("adminpassword"));

		// Click on Login Button
		driver.findElement(By.id("login-button")).click();
		
		
		Thread.sleep(Duration.ofSeconds(5));

		// Verify login was successful

		// Close the Browser

	}

	@Test
	public void verifyloginWithInValidCredentials() {

		// Launch A Browser

		// Navigate to Test Site URL

		// Enter InvalidValid UserName

		// Enter InvalidValid Password

		// Click on Login Button

		// Verify login was successful

		// Close the Browser

	}

}
