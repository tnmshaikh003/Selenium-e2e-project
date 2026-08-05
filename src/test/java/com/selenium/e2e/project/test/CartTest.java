package com.selenium.e2e.project.test;

import java.io.IOException;

import org.testng.annotations.Test;

import com.selenium.e2e.project.base.BaseTest;
import com.selenium.e2e.project.page.CartPage;


import junit.framework.Assert;

public class CartTest extends BaseTest {

    public CartTest() throws IOException {
        super();
    }

    @Test
    public void CartFunctionTest() throws IOException {
        LoginTest loginPage = new LoginTest();
        loginPage.loginTest();
        CartPage cartPage = new CartPage(driver.get());
        cartPage.clickOnAddToCart("Sauce Labs Backpack");
        int noAppearsOnCart = cartPage.noAppearsOnCart();
        cartPage.clickOnCart();
        int itemAvailableOnCart = cartPage.NoOfItemInCart();
        Assert.assertEquals(noAppearsOnCart, itemAvailableOnCart);
        Assert.assertTrue(cartPage.verifyCartItemMatches("Sauce Labs Backpack"));


    }
}
