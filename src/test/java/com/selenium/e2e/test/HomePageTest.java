package com.selenium.e2e.test;

import java.io.IOException;

import org.testng.Assert;

import org.testng.annotations.Test;

import com.selenium.e2e.base.BaseTest;
import com.selenium.project.page.HomePage;
import com.selenium.project.page.LoginPage;


public class HomePageTest extends BaseTest{

    public HomePageTest() throws IOException {
        super();
    }


    @Test
    public void homePageTest() throws IOException {
        HomePage hp = new HomePage(driver.get());
        LoginTest lt = new LoginTest();
        lt.loginTest();
        hp.selectDropdown();
        hp.clickOnHamBtn();
        hp.clickOnAbt();
        try {
            Thread.sleep(10000);
        } catch (Exception e) {
            // TODO: handle exception
        }
        
        
    }
   
}
