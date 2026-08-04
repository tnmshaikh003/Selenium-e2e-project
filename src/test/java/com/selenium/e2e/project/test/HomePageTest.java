package com.selenium.e2e.project.test;

import java.io.IOException;



import org.testng.annotations.Test;

import com.selenium.e2e.project.base.BaseTest;
import com.selenium.e2e.project.page.HomePage;



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
       
        
    }
   
}
