package com.selenium.e2e.project.Listener;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.reporter.ExtentSparkReporter;

import java.io.File;

public class ExtentManager {

    private static ExtentReports extent;
    private static ThreadLocal<ExtentTest> extentTest = new ThreadLocal<>();

    public static void init(String reportPath) {
        ExtentSparkReporter spark = new ExtentSparkReporter(reportPath);
        extent = new ExtentReports();
        extent.attachReporter(spark);
    }

    public static void createTest(String name) {
        if (extent == null) {
            String defaultPath = System.getProperty("user.dir") + File.separator + "target" + File.separator + "extent-report" + File.separator + "ExtentReport.html";
            init(defaultPath);
        }
        extentTest.set(extent.createTest(name));
    }

    public static ExtentTest getTest() {
        return extentTest.get();
    }

    public static void flush() {
        if (extent != null) extent.flush();
    }
}
