package com.selenium.e2e.project.page;

import org.openqa.selenium.By;
import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

import com.selenium.e2e.project.BasePage.DriverUtil;

public class CartPage extends DriverUtil {
    
   private  DriverUtil driverUtil;
  
   @FindBy(xpath="//div[@class='shopping_cart_container']/a")
   WebElement cartContainerXpath;

   @FindBy(xpath="//div[@class='cart_item']")
   WebElement cartItemXPath ;

   @FindBy(xpath="//span[@class='shopping_cart_badge']")
   WebElement noOnCartXPath;

   @FindBy(xpath="//div[@class='inventory_item_name']")
   WebElement inventoryItem;

   


   public CartPage(WebDriver driver){
    super(driver);
    this.driverUtil = new DriverUtil(driver);
    PageFactory.initElements(driver, this);
   }


   public void clickOnAddToCart(String productName){
       By itemButton = By.xpath("//*[contains(text(),'" + productName + "')]/ancestor::div[@class='inventory_item_description']/child::div[@class='pricebar']/button");
       this.driverUtil.click(itemButton);
   }

   public void clickOnCart(){
    this.driverUtil.click(cartContainerXpath);

   }

   public int NoOfItemInCart(){
       return  this.driverUtil.getElements(By.xpath("//div[@class='cart_item']")).size();
   }

   public int noAppearsOnCart(){
    return Integer.parseInt(this.driverUtil.getText(noOnCartXPath));
   }

   public boolean verifyCartItemMatches(String product){
        String inventoryStringItemName = this.driverUtil.getText(inventoryItem);
        if(inventoryStringItemName.equalsIgnoreCase(product)){
            return true;
        }

        return false;
   }


   
}
