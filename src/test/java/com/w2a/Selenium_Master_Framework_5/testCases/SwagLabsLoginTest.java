package com.w2a.Selenium_Master_Framework_5.testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.Selenium_Master_Framework_5.pageObjects.LoginPage;
import com.w2a.Selenium_Master_Framework_5.pageObjects.ProductsPage;
import com.w2a.Selenium_Master_Framework_5.testSetUp.TestSetup;

public class SwagLabsLoginTest extends TestSetup {

	@Test
	public void verifyloginWithValidCredentials(){
		LoginPage loginPage = new LoginPage();
		ProductsPage productsPage = loginPage.doLoginWithValidCredentials("standard_user", "secret_sauce");
		Assert.assertTrue(productsPage.isProductTitleDisplayed());
		

		
	}

	@Test
	public void verifyloginWithInValidCredentials() throws InterruptedException {
		LoginPage loginPage = new LoginPage();
		loginPage.doLoginWithInvalidcredentials("standard_user", "secrdhfjshdfhskdfhet_sauce");
		Thread.sleep(Duration.ofSeconds(5));
		Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed for invalid login");


	}

}
