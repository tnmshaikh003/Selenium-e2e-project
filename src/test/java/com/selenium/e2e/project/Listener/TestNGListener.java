package com.selenium.e2e.project.Listener;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardCopyOption;

import org.apache.logging.log4j.core.util.FileUtils;
import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;
import org.openqa.selenium.WebDriver;
import org.testng.ITestContext;
import org.testng.ITestListener;
import org.testng.ITestResult;
import org.testng.Reporter;

import com.aventstack.extentreports.Status;

import com.selenium.e2e.project.base.BaseTest;

public class TestNGListener implements ITestListener {

    

    @Override
    public void onTestStart(ITestResult result) {
        Reporter.log("Starting test: " + result.getMethod().getMethodName(), true);
        ExtentManager.createTest(result.getMethod().getMethodName());
    }

    @Override
    public void onTestSuccess(ITestResult result) {
        Reporter.log("Test succeeded: " + result.getMethod().getMethodName(), true);
        String path = takeScreenshot(result);
        if (ExtentManager.getTest() != null) {
            ExtentManager.getTest().log(Status.PASS, "Test passed");
            if (path != null) ExtentManager.getTest().addScreenCaptureFromPath(path);
        }
    }

    @Override
    public void onTestFailure(ITestResult result) {
        Reporter.log("Test failed: " + result.getMethod().getMethodName(), true);
        String path = takeScreenshot(result);
        if (ExtentManager.getTest() != null) {
            ExtentManager.getTest().log(Status.FAIL, result.getThrowable());
            if (path != null) ExtentManager.getTest().addScreenCaptureFromPath(path);
        }
    }

    @Override
    public void onTestSkipped(ITestResult result) {
        Reporter.log("Test skipped: " + result.getMethod().getMethodName(), true);
    }

    @Override
    public void onTestFailedButWithinSuccessPercentage(ITestResult result) {
        // not used
    }

    @Override
    public void onStart(ITestContext context) {
        Reporter.log("Test context started: " + context.getName(), true);
        String reportDir = System.getProperty("user.dir") + File.separator + "target" + File.separator + "extent-report";
        File rd = new File(reportDir);
        if (!rd.exists()) rd.mkdirs();
        String reportPath = reportDir + File.separator + "ExtentReport_" + System.currentTimeMillis() + ".html";
        ExtentManager.init(reportPath);
    }

    @Override
    public void onFinish(ITestContext context) {
        Reporter.log("Test context finished: " + context.getName(), true);
        ExtentManager.flush();
    }
    private String takeScreenshot(ITestResult result) {
        try {
            WebDriver driver = BaseTest.driver.get();
            if (driver == null) {
                Reporter.log("WebDriver was null - cannot take screenshot", true);
                return null;
            }

            if (!(driver instanceof TakesScreenshot)) {
                Reporter.log("Driver does not support screenshots", true);
                return null;
            }

            File srcFile = ((TakesScreenshot) driver).getScreenshotAs(OutputType.FILE);
            String screenshotsDir = System.getProperty("user.dir") + File.separator + "target" + File.separator + "screenshots";
            File dir = new File(screenshotsDir);
            if (!dir.exists()) {
                dir.mkdirs();
            }

            String fileName = result.getMethod().getMethodName() + "_" + System.currentTimeMillis() + ".png";
            Path target = new File(dir, fileName).toPath();
            Files.copy(srcFile.toPath(), target, StandardCopyOption.REPLACE_EXISTING);

            String relativePath = "target/screenshots/" + fileName;
            Reporter.log("Saved screenshot: " + target.toString(), true);
            Reporter.log("<a href='" + relativePath + "'>Screenshot</a>");
            Reporter.log("<br/><a href='" + relativePath + "'><img src='" + relativePath + "' height='200' width='200' /></a>");
            return target.toString();

        } catch (IOException e) {
            Reporter.log("Failed to save screenshot: " + e.getMessage(), true);
            return null;
        } catch (Exception e) {
            Reporter.log("Unexpected error taking screenshot: " + e.getMessage(), true);
            return null;
        }
    }

}
