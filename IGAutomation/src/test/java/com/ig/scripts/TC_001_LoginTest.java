package com.ig.scripts;

import static com.ig.extent.report.ExtentTestManager.startTest;

import org.testng.annotations.Test;
import java.lang.reflect.Method;
import com.ig.utils.DriverTestCase;

public class TC_001_LoginTest extends DriverTestCase {
	
	
	
	@Test
	public void loginMethod(Method method)
	{
		startTest(method.getName(), "loginMethod");
		//Reading email address and password
		String email= propertyReader.readApplicationFile("emailAddress");
		String pass= propertyReader.readApplicationFile("password");
		
		//Login into application
		loginPage.loginIntoApplication(email, pass);
		
		
		//Login into IG Application
		//loginPage.loginIntoIGApplication(email, pass);
		
	}
	
	

}
