package com.selenium.e2e.project.Util;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public  class DriverUtil{
    
    private  WebDriver driver;
    private  WebDriverWait wait;
    private  final int TIMEOUT = 20;

    public DriverUtil(WebDriver driver){
        this.driver = driver;
    }

    public  void click(WebElement wl){
        try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            wait.until(ExpectedConditions.elementToBeClickable(wl));
            wl.click();
        } catch (Exception e) {
            // TODO: handle exception
            e.getMessage();
        }
    }

    public String  getText(WebElement wl){
        String text ;
         try {
            wait = new WebDriverWait(driver, Duration.ofSeconds(TIMEOUT));
            wait.until(ExpectedConditions.visibilityOf(wl));
           text= wl.getText();
            
        } catch (Exception e) {
            // TODO: handle exception
           text= e.getMessage();
        }
        return text;
    }


}
