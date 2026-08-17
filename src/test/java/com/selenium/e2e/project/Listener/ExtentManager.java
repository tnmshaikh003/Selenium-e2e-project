package com.selenium.e2e.project.Listener;


import java.text.SimpleDateFormat;
import java.util.Date;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;


public class ExtentManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();


    public static ExtentReports getReportInstance(){

        if(extent ==null){
            String timeStamp = new SimpleDateFormat("yyyy-MM-DD_HH-mm-ss").format(new Date());
            String reportPath = "report/Extent_"+timeStamp+".html";
            ExtentSparkReporter reporter = new ExtentSparkReporter(reportPath);
            reporter.config().setDocumentTitle("Automation Report");
            reporter.config().setReportName("Test Execution Report");
           extent = new ExtentReports();
           extent.attachReporter(reporter);

;
        }

        


        return extent;
    }

    public static ExtentTest createTest(String testName){
        ExtentTest test = getReportInstance().createTest(testName);
        extentTest.set(test);
        return test;
    }

    public static ExtentTest getTest(){
        return extentTest.get();
    }

}