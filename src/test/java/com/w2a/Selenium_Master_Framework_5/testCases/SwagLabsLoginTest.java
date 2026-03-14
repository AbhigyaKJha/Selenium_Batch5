package com.w2a.Selenium_Master_Framework_5.testCases;

import java.time.Duration;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.w2a.Selenium_Master_Framework_5.pageObjects.LoginPage;
import com.w2a.Selenium_Master_Framework_5.pageObjects.ProductsPage;
import com.w2a.Selenium_Master_Framework_5.testSetUp.TestSetup;
import com.w2a.Selenium_Master_Framework_5.utils.Data;

public class SwagLabsLoginTest extends TestSetup {

	@Test(dataProviderClass = Data.class, dataProvider = "data")
	public void verifyloginWithValidCredentials(String userName,String password){
		LoginPage loginPage = new LoginPage();
		ProductsPage productsPage = loginPage.doLoginWithValidCredentials(userName, password);
		Assert.assertTrue(productsPage.isProductTitleDisplayed());
		

		
	}

	@Test(dataProviderClass = Data.class, dataProvider = "data")
	public void verifyloginWithInValidCredentials(String userName,String password) throws InterruptedException {
		LoginPage loginPage = new LoginPage();
		loginPage.doLoginWithInvalidcredentials(userName, password);
		Thread.sleep(Duration.ofSeconds(5));
		Assert.assertTrue(loginPage.isErrorMessageDisplayed(), "Error message is not displayed for invalid login");


	}

}
