package com.ig.scripts;

import static com.ig.extent.report.ExtentTestManager.startTest;

import java.lang.reflect.Method;

import org.testng.annotations.Test;

import com.ig.utils.DriverTestCase;

public class TC_003_SearchTShirt extends DriverTestCase {

	
	@Test
	public void SearchTShirtMethod(Method method) throws InterruptedException
	{
		startTest(method.getName(), "SearchTShirtMethod");
		//Reading email address and password
		String email= propertyReader.readApplicationFile("emailAddress");
		String pass= propertyReader.readApplicationFile("password");
				
		//Login into application
		loginPage.loginIntoApplication(email, pass);
		
		
		//search the product
		homePage.mouseHoverOnWomenNavigationBar();
		homePage.clickOnTshirtSubMenu();
		
		//click on T-shirt product
		pdpPage.clickOnTshirtProduct();
		
		//Add to cart
		// Proceed to  checkout
		// Proceed to  checkout
		// Select card
		// Pay the amount
	
		
		
		//Logout from application
		loginPage.logoutFromApplication();
	}
	
	
}
