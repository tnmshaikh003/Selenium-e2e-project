package com.selenium.e2e.project.test;

import java.io.IOException;

import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.selenium.e2e.project.base.BaseTest;
import com.selenium.e2e.project.page.HomePage;



public class HomePageTest extends BaseTest{

    public static final Logger logger = LogManager.getLogger(HomePageTest.class);

    public HomePageTest() throws IOException {
        super();
    }


    @Test
    public void homePageTest() throws IOException {
        HomePage hp = new HomePage(driver.get());
         LoginTest lt = new LoginTest();
        lt.loginTest();
        hp.selectFromDropdown(prop.getProperty("state"));
        logger.info("Value selected from dropdown?: "+"za");
        hp.clickOnHamBtn();
        hp.clickOnAbt();
       
        
    }
   
}
