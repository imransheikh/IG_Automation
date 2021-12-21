package com.ig.extent.report;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import com.ig.utils.PropertyReader;

public class ExtentManager {
      
	    public static final ExtentReports extentReports = new ExtentReports();
		
	
   
        public synchronized static ExtentReports createExtentReports() {
        	String extentReportPath = System.getProperty("user.dir") + "/ExtentReport/IG-ExtentReport.html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(extentReportPath);
            reporter.config().setReportName("Sample Extent Report");
            extentReports.attachReporter(reporter);
            extentReports.setSystemInfo("Company", "IG");
            extentReports.setSystemInfo("Author", "Olga");
            PropertyReader propertyReader = new PropertyReader();
    		String browserType = propertyReader.readApplicationFile("BROWSER");
    		extentReports.setSystemInfo("Browser", browserType);
            
            return extentReports;
        }
        
     
       
    }


