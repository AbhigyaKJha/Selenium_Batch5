package com.w2a.Selenium_Master_Framework_5.pageObjects;

import org.openqa.selenium.By;

import com.w2a.Selenium_Master_Framework_5.utils.ElementInteraction;

public class ProductsPage {
	
	
	private By productTitle = By.xpath("//span[text()='Products']");
	private By shoppingCartBadge = By.xpath("//a[@data-test='shopping-cart-link']");
	
	
	//producTitle is displayed or not
	public boolean isProductTitleDisplayed() {
		return ElementInteraction.isElementDisplayed(productTitle);
	}
	
	
	//Cart logo is displayed or not
	
	
	

}
