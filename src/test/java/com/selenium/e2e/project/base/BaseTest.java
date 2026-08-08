package com.selenium.e2e.project.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.chrome.ChromeOptions;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.edge.EdgeOptions;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.openqa.selenium.firefox.FirefoxOptions;
import org.testng.annotations.BeforeMethod;

import com.selenium.e2e.project.HelperClass.ConfigReader;

import org.testng.annotations.AfterMethod;

public class BaseTest {

    public static Properties prop;

    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();
    String env;
    String browserName;
    boolean isHeadless;

    public BaseTest() throws IOException {
        prop = new Properties();
        env = ConfigReader.getEnvironment();
        browserName = ConfigReader.getDefaultBrowser();
        isHeadless = ConfigReader.isHeadless();
        String testDataPath = ConfigReader.getTestDataPath(env);
        // String
        FileInputStream ip = new FileInputStream(testDataPath);
        prop.load(ip);
    }

    @BeforeMethod
    public void initialization() throws Exception {


        if (browserName.equalsIgnoreCase("Chrome")) {
            ChromeOptions chromeOptions = new ChromeOptions();
            if (isHeadless) {
                chromeOptions.addArguments("--headless=new");
            }
            driver.set(new ChromeDriver(chromeOptions));

        } else if (browserName.equalsIgnoreCase("Edge")) {
            EdgeOptions edgeOptions = new EdgeOptions();
            if (isHeadless) {
                edgeOptions.addArguments("--headless=new");
            }
            driver.set(new EdgeDriver(edgeOptions));

        } else if (browserName.equalsIgnoreCase("Firefox")) {
            FirefoxOptions firefoxOptions = new FirefoxOptions();
            if (isHeadless) {
                firefoxOptions.addArguments("--headless=new");
            }
            driver.set(new FirefoxDriver(firefoxOptions));

        } else {
            throw new IllegalArgumentException("Unsupported browser: " + browserName);
        }

        driver.get().get(ConfigReader.getBaseUrl(env));
        driver.get().manage().window().maximize();
        driver.get().manage().deleteAllCookies();
        driver.get().manage().timeouts().pageLoadTimeout(Duration.ofSeconds(20));
        driver.get().manage().timeouts().implicitlyWait(Duration.ofSeconds(20));
    }

    @AfterMethod
    public void tearDown() {
        driver.get().quit();
        driver.remove();
    }
}