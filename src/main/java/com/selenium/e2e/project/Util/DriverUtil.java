package com.selenium.e2e.project.Util;

import java.time.Duration;
import java.util.List;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.interactions.Actions;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class DriverUtil {

    private WebDriver driver;
    private WebDriverWait wait;
    private final int TIMEOUT = 20;

    public DriverUtil(WebDriver driver) {
        this.driver = driver;
    }

    public void click(WebElement wl) {
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            wait.until(ExpectedConditions.elementToBeClickable(wl));
            wl.click();
        } catch (Exception e) {
            // TODO: handle exception
            e.getMessage();
        }
    }

    public List<WebElement> getElements(By locator) {

        try {
            List<WebElement> wl = this.driver.findElements(locator);
            return wl;
        } catch (Exception e) {
            e.getMessage();
        }
        return null;
    }

    public void click(By locator) {
        try {
            WebElement wl = driver.findElement(locator);
            wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            wait.until(ExpectedConditions.elementToBeClickable(wl));
            wl.click();
        } catch (Exception e) {
            // TODO: handle exception
            e.getMessage();
        }
    }

    public String getText(WebElement wl) {
        String text;
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            wait.until(ExpectedConditions.visibilityOf(wl));
            text = wl.getText();

        } catch (Exception e) {
            // TODO: handle exception
            text = e.getMessage();
        }
        return text;
    }

    public void hoverOnElement(WebElement wl){
        try{
            wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            wait.until(ExpectedConditions.visibilityOf(wl));
            Actions action = new Actions(driver);
            action.moveToElement(wl).build().perform();
            
            
        }catch(Exception e){
            e.getMessage();
        }
    }

}
