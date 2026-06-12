package com.selenium.e2e.project.test;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.selenium.e2e.project.base.BaseTest;
import com.selenium.e2e.project.page.LoginPage;

public class LoginTest extends BaseTest{

    public LoginTest() throws IOException {
        super();
    }


    @Test
    public void loginTest() {
        LoginPage lp = new LoginPage(driver.get());
        Assert.assertTrue(lp.navigateToSwagLab());
        lp.enterUserName(prop.getProperty("userName"));
        lp.enterPassword(prop.getProperty("password"));
       Assert.assertTrue( lp.clickOnLogIn().isHeaderDisplayed());
    
        
    }
   
}
