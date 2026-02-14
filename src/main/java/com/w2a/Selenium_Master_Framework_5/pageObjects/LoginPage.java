package com.w2a.Selenium_Master_Framework_5.pageObjects;

import org.openqa.selenium.By;

import com.w2a.Selenium_Master_Framework_5.testSetUp.TestSetup;
import com.w2a.Selenium_Master_Framework_5.utils.ElementInteraction;

public class LoginPage extends TestSetup {

	// Locators for All Elements
	private By userName = By.id("user-name");
	private By password = By.id("password");
	private By loginButton = By.id("login-button");
	private By loginErrorMessage = By.xpath("//h3[@data-test='error']");

	// Action Methods that can be performed on this page

	// What is page object model -> It is a design pattern where one page action
	// will return the object of another
	// page

	// Successful Login Action -> Products Page

	// login() -> sucess -> navigating to products page ->login()-> new Product()

	public ProductsPage doLoginWithValidCredentials(String userName, String password) {
		// enter the valid username
		ElementInteraction.type(this.userName, userName);

		// enter the valid password
		ElementInteraction.type(this.password, password);

		// click on login button -> Products Page
		ElementInteraction.click(this.loginButton);

		return new ProductsPage();
	}

	public LoginPage doLoginWithInvalidcredentials(String userName, String password) {
		// enter the valid username
		ElementInteraction.type(this.userName, userName);

		// enter the valid password
		ElementInteraction.type(this.password, password);

		// click on login button -> Products Page
		ElementInteraction.click(this.loginButton);

		return this;

	}

}
