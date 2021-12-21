package com.ig.pages;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ig.utils.DriverHelper;

public class PDPPage extends DriverHelper {
	
	// ==================Home page locators=======================	
		
		@FindBy(xpath = "//a[@class='product-name' and @title='Faded Short Sleeve T-shirts']")
		private WebElement TshirtProductName;
		
		

		// ================================================================

		public PDPPage(WebDriver webdriver) {
			super(webdriver);
			PageFactory.initElements(getWebDriver(), this);

		}
		

		public void clickOnTshirtProduct() throws InterruptedException
		{
			TshirtProductName.click();
		}
		
}
