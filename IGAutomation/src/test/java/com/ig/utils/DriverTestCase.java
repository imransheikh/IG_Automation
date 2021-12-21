package com.ig.utils;

import java.util.Random;
import java.util.concurrent.TimeUnit;
import java.util.Random;
import java.util.concurrent.TimeUnit;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.openqa.selenium.JavascriptExecutor;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.ie.InternetExplorerDriver;
import org.openqa.selenium.remote.RemoteWebDriver;
import org.openqa.selenium.support.PageFactory;
import org.testng.annotations.AfterClass;
import org.testng.annotations.AfterMethod;
import org.testng.annotations.AfterSuite;
import org.testng.annotations.AfterTest;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeSuite;
import org.testng.annotations.BeforeTest;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ig.pages.HomePage;
import com.ig.pages.LoginPage;
import com.ig.pages.PDPPage;

public abstract class DriverTestCase {
	
	public PropertyReader propertyReader;
	public LoginPage loginPage;
	public HomePage homePage;
	public PDPPage pdpPage;

	protected WebDriver driver;
	String driverType;
	public static ExtentReports extent;
	public static ExtentSparkReporter sparkReport;

	enum DriverType {
		Firefox, IE, Chrome, Edge
	}

	@BeforeClass
	public void setUp() {
		propertyReader = new PropertyReader();
		driverType = propertyReader.readApplicationFile("BROWSER");

		if (DriverType.Firefox.toString().equals(driverType)) {
			String geckoDriverPath = System.getProperty("user.dir") + "/drivers/geckodriver.exe";
			System.setProperty("webdriver.gecko.driver", geckoDriverPath);
			driver = new FirefoxDriver();

		} else if (DriverType.IE.toString().equals(driverType)) {
			
			String IEDriverPath = System.getProperty("user.dir") + "/drivers/IEDriverServer.exe";
			System.setProperty("webdriver.ie.driver", IEDriverPath);
			driver = new InternetExplorerDriver();
		}	
			else if (DriverType.Edge.toString().equals(driverType)) {
				
				String EdgeDriverPath = System.getProperty("user.dir") + "/drivers/msedgedriver.exe";
				System.setProperty("webdriver.edge.driver", EdgeDriverPath);
				driver = new EdgeDriver();

		} else if (DriverType.Chrome.toString().equals(driverType)) {
			ChromeOptions chromeOptions = new ChromeOptions();
			String chromeDriverPath = System.getProperty("user.dir") + "/drivers/chromedriver.exe";
			System.out.println("Chrome path: " + chromeDriverPath);
			System.setProperty("webdriver.chrome.driver", chromeDriverPath);
			driver = new ChromeDriver(chromeOptions);
		} else {
			driver = new FirefoxDriver();
		}

		driver.manage().window().maximize();
		driver.manage().timeouts().implicitlyWait(60, TimeUnit.SECONDS);
		driver.manage().timeouts().pageLoadTimeout(60, TimeUnit.SECONDS);

		// JavascriptExecutor
		JavascriptExecutor js = (JavascriptExecutor) driver;
		js.executeScript("return document.readyState").toString().equals("complete");

		String applicationUrl = propertyReader.readApplicationFile("ApplicationURL");
		getWebDriver().get(applicationUrl);

		loginPage = PageFactory.initElements(driver, LoginPage.class);
		homePage = PageFactory.initElements(driver, HomePage.class);
		pdpPage= PageFactory.initElements(driver, PDPPage.class);

	}

	@AfterClass
	public void tearDowm() {
		driver.quit();

	}

	public WebDriver getWebDriver() {
		return driver;
	}

	public PropertyReader getProperty() {
		return propertyReader;
	}

	public int getRandomInteger(int aStart, int aEnd, Random aRandom) {
		if (aStart > aEnd) {
			throw new IllegalArgumentException("Start cannot exceed End.");
		}
		// get the range, casting to long to avoid overflow problems
		long range = (long) aEnd - (long) aStart + 1;

		long fraction = (long) (range * aRandom.nextDouble());
		int randomNumber = (int) (fraction + aStart);
		return randomNumber;
	}

	public String randomString(int len) {

		String AB = "ABCDEFGHIJKLMNOPQRSTUVWXYZ";
		Random rnd = new Random();
		StringBuilder sb = new StringBuilder(len);
		for (int i = 0; i < len; i++)
			sb.append(AB.charAt(rnd.nextInt(AB.length())));
		return sb.toString();
	}

}
