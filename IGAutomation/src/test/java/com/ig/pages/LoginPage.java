package com.ig.pages;

import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.ig.utils.DriverHelper;

public class LoginPage extends DriverHelper {
	
// ==================Login page locators=======================	
	
	@FindBy(className = "login")
	private WebElement singInLink;
	
	@FindBy(id = "email")
	private WebElement emailAddress;
	
	@FindBy(name = "passwd")
	private WebElement password;

	@FindBy(xpath = "//button[@type='submit' and @name='SubmitLogin']")
	private WebElement LoginButton;

	@FindBy(id = "email_create")
	private WebElement createAccountEmailAddress;
	
	@FindBy(name = "SubmitCreate")
	private WebElement createAccountButton;
	
	@FindBy(id = "create_account_error")
	private WebElement createAccountValidationMsg;

	@FindBy(className = "logout")
	private WebElement logout;


	// ================================================================

	public LoginPage(WebDriver webdriver) {
		super(webdriver);
		PageFactory.initElements(getWebDriver(), this);

	}
	
	
	public void clickOnSignInLink()
	{
		singInLink.click();
	}
	

	public void enterEmailAddress(String email)
	{
		emailAddress.clear();
		emailAddress.sendKeys(email);
	}
	
	public void enterPassword(String pass)
	{
		password.clear();
		password.sendKeys(pass);
	}
	
	
	public void clickOnLoginButton()
	{
		LoginButton.click();
	}
	
	
	public void clickOnLogin1()
	{
		//provide locators and perfrom the action
		// locator.click()
	}
	
	

	public void enterEmail1(String email)
	{
		//provide locators and perfrom the action
	}
	
	public void clickOnNextButton()
	{
		//provide locators and perfrom the action
	}
	
	public void enterPassword1(String pass)
	{
		
	}
	
	
	
	public void loginIntoIGApplication(String email, String pass)
	{
		//Click on Login button
		clickOnLogin1();
		//Enter email address
		enterEmail1(email);
		//click on Next button
		clickOnNextButton();
		//enter password 
		 enterPassword1(pass);
		//click on Next button
		clickOnNextButton();
		
	}
	
	
	
	public void loginIntoApplication(String email, String pass)
	{
		clickOnSignInLink();
		enterEmailAddress(email);
		enterPassword(pass);
		clickOnLoginButton();
		
	}
	
	public void enterCreateAccountEmail(String createEmailAddress)
	{
		createAccountEmailAddress.clear();
		createAccountEmailAddress.sendKeys(createEmailAddress);
	}

	
	public void clickOnCreateAccountButton()
	{
		createAccountButton.click();
	}
	
	
	public String getValidationMessage() throws InterruptedException
	{
		Thread.sleep(3000);
		return createAccountValidationMsg.getText();
		
	}
	
	
	
	public void logoutFromApplication()
	{
		logout.click();
		
	}
	
	
}
