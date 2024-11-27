package utils;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;
import io.cucumber.java.Scenario;

import java.io.File;

public class ExtendReport {

    private static ExtentReports extent;
    private static ExtentTest test;
    private static String reportPath = System.getProperty("user.dir") + "/reports/extentReport.html";

   
    public static void init() {
        if (extent == null) {
            extent = new ExtentReports();
            ExtentSparkReporter sparkReporter = new ExtentSparkReporter(reportPath);
            extent.attachReporter(sparkReporter);
        }
    }

   
    public static void createTest(Scenario scenario) {
        test = extent.createTest(scenario.getName());
    }

   
    public static void logResult(Scenario scenario) {
    	
        if (scenario.isFailed()) {
            test.fail("Scenario failed: " + scenario.getName());
        } else {
            test.pass("Scenario passed: " + scenario.getName());
        }
    }

    
    public static void flushReport() {
        if (extent != null) {
            extent.flush();  
        }
    }

  
    public static void clearOldReport() {
        File reportFile = new File(reportPath);
        if (reportFile.exists()) {
            reportFile.delete(); 
        }
    }
}
