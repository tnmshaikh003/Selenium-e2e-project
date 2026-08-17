package com.selenium.e2e.project.Listener;

import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.ExtentReports;

public class TestNGListener implements ITestListener {

    protected static ExtentReports extent;

     public void onTestStart(ITestResult result) {
         Reporter.log("Starting test: " + result.getMethod().getMethodName(), true);
         ExtentManager.createTest(result.getMethod().getMethodName());

   }

   public void onTestSuccess(ITestResult result) {
    Reporter.log("Test succeeded: " + result.getMethod().getMethodName(), true);




   }

   public void onTestFailure(ITestResult result) {
    Reporter.log("Test Failed: " + result.getMethod().getMethodName(), true);
   }

   public void onTestSkipped(ITestResult result) {
    Reporter.log("Test skipped: " + result.getMethod().getMethodName(), true);
   }

   public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
   }

   public void onTestFailedWithTimeout(ITestResult result) {
      this.onTestFailure(result);
   }

   public void onStart(ITestContext context) {
    extent = ExtentManager.getReportInstance();
   }

   public void onFinish(ITestContext context) {
    extent.flush();

   }



}