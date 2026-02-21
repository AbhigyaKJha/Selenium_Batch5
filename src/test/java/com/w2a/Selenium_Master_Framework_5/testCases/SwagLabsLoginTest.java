package com.w2a.Selenium_Master_Framework_5.testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.Selenium_Master_Framework_5.pageObjects.LoginPage;
import com.w2a.Selenium_Master_Framework_5.pageObjects.ProductsPage;
import com.w2a.Selenium_Master_Framework_5.testSetUp.TestSetup;
import com.w2a.Selenium_Master_Framework_5.utils.ApplicationConstants;

public class SwagLabsLoginTest extends TestSetup {

	@Test()
	public void verifyloginWithValidCredentials() throws InterruptedException {
		LoginPage loginPage = new LoginPage();
		ProductsPage productsPage = loginPage.doLoginWithValidCredentials("standard_user", "secret_sauce");
		Assert.assertTrue(productsPage.isProductTitleDisplayed(), ApplicationConstants.Products_PAGE_TITLE_NOT_PRESENT);

		Thread.sleep(Duration.ofSeconds(5));

		
	}

	@Test
	public void verifyloginWithInValidCredentials() {

		// TODO : complete the test case for login with invalid credentials

		// Launch A Browser

		// Navigate to Test Site URL

		// Enter InvalidValid UserName

		// Enter InvalidValid Password

		// Click on Login Button

		// add assertion to verify that login error message was displayed

	}

}
