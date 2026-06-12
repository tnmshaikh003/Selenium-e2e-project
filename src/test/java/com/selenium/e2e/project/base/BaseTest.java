package com.selenium.e2e.project.base;

import java.io.FileInputStream;
import java.io.IOException;
import java.time.Duration;
import java.util.Properties;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.chrome.ChromeDriver;
import org.openqa.selenium.edge.EdgeDriver;
import org.openqa.selenium.firefox.FirefoxDriver;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.AfterMethod;

public class BaseTest {

    public static Properties prop;
    public static ThreadLocal<WebDriver> driver = new ThreadLocal<>();

    public BaseTest() throws IOException {
        prop = new Properties();
        FileInputStream ip = new FileInputStream("config.properties");
        prop.load(ip);
    }

    @BeforeMethod
    public void initialization() {
        String browserName = prop.getProperty("browserName");
        if (browserName.equalsIgnoreCase("Chrome")) {
            driver.set(new ChromeDriver());
        }
        else if(browserName.equalsIgnoreCase("Edge")){
            driver.set(new EdgeDriver() );
            }
         else {

            driver.set(new FirefoxDriver());
        }
        driver.get().get(prop.getProperty("url"));
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
