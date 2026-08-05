package com.selenium.e2e.project.test;

import java.io.IOException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;

import org.testng.annotations.Test;

import com.selenium.e2e.project.base.BaseTest;
import com.selenium.e2e.project.page.LoginPage;

public class LoginTest extends BaseTest{

    private static final Logger logger = LogManager.getLogger(LoginTest.class);

    public LoginTest() throws IOException {
        super();
    }


    @Test(description = "Login with valid credential")
    public void loginTest() {
        LoginPage lp = new LoginPage(driver.get());
        Assert.assertTrue(lp.navigateToSwagLab());
        logger.log(Level.INFO,"Succesfully navigated to Swag lab");
        lp.enterUserName(prop.getProperty("userName"));
        logger.log(Level.INFO,"Succesfully entered username");
        lp.enterPassword(prop.getProperty("password"));
        logger.log(Level.INFO,"Succesfully entered password");
       Assert.assertTrue( lp.clickOnLogIn().isHeaderDisplayed());
       logger.log(Level.INFO,"Succesfully veried header text");
        
    }
   
}
