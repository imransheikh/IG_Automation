package com.ig.pages;



import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ig.utils.DriverHelper;

public class HomePage extends DriverHelper {
	
	// ==================Home page locators=======================	
		
		@FindBy(xpath = "//a[@title='Women']")
		private WebElement womenNavigation;
		
		@FindBy(xpath = "(//a[@title='T-shirts'])[1]")
		private WebElement tshitsSubMenu;
		
		

		// ================================================================

		public HomePage(WebDriver webdriver) {
			super(webdriver);
			PageFactory.initElements(getWebDriver(), this);

		}
		

		public void mouseHoverOnWomenNavigationBar() throws InterruptedException
		{
			Thread.sleep(2000);
			Actions action= new Actions(driver);
			action.moveToElement(womenNavigation).perform();
		}
		
		
		
		public void clickOnTshirtSubMenu()
		{
			tshitsSubMenu.click();
		}

		
}