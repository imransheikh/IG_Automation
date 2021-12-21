package com.ig.scripts;

import static com.ig.extent.report.ExtentTestManager.startTest;
import static org.testng.Assert.assertTrue;
import java.lang.reflect.Method;
import org.testng.annotations.Test;
import com.ig.utils.DriverTestCase;

public class TC_002_CheckValidationOnCreateAccount extends DriverTestCase {

	
	
	@Test
	public void createAccountValidation(Method method) throws InterruptedException
	{
		startTest(method.getName(), "createAccountValidation");
		//click on sign in link
		loginPage.clickOnSignInLink();
		
		//enter create account email address
		String createEmailAddress= propertyReader.readApplicationFile("createAccountEmailAddress");
		loginPage.enterCreateAccountEmail(createEmailAddress);
		
		//click on create account button
		loginPage.clickOnCreateAccountButton();
		
		//getting the validation message
		String validationMsg= loginPage.getValidationMessage();
		assertTrue(validationMsg.contains("An account using this email address has already been registered"),
				"An account using this email address has already been registered should displayed ");
		assertTrue(false);
	}
	
}
