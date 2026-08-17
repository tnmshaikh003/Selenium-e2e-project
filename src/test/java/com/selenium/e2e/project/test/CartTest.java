package com.selenium.e2e.project.test;

import java.io.IOException;

import org.apache.logging.log4j.Level;
import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.annotations.Test;

import com.aventstack.extentreports.ExtentReports;
import com.aventstack.extentreports.ExtentTest;
import com.aventstack.extentreports.Status;
import com.selenium.e2e.project.base.BaseTest;
import com.selenium.e2e.project.page.CartPage;

import junit.framework.Assert;

public class CartTest extends BaseTest {

    public static final Logger logger = LogManager.getLogger(CartTest.class);

    public CartTest() throws IOException {
        super();
    }

    @Test
    public void verifyAddToCartFunctionlity() throws IOException {
        LoginTest loginPage = new LoginTest();
        loginPage.loginTest();
        CartPage cartPage = new CartPage(driver.get());
        cartPage.clickOnAddToCart("Sauce Labs Backpack");
        logger.log(Level.INFO, "successfully clicked on add to cart");
        int noAppearsOnCart = cartPage.noAppearsOnCart();
        logger.log(Level.INFO, "no showing on cart icon: " + noAppearsOnCart);
        cartPage.clickOnCart();
        logger.log(Level.INFO, "successfully clicked on cart");
        int itemAvailableOnCart = cartPage.NoOfItemInCart();
        logger.log(Level.INFO, "item available in the cart: " + itemAvailableOnCart);
        Assert.assertEquals(noAppearsOnCart, itemAvailableOnCart);
        logger.log(Level.INFO, "Count matched");
        Assert.assertTrue(cartPage.verifyCartItemMatches("Sauce Labs Backpack"));
        logger.log(Level.INFO, "Item matched - correct item get stored in the cart");

    }
}
