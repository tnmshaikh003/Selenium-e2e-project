package com.selenium.project.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;

public class LoginPage {
    public WebDriver driver;
  

    @FindBy(xpath="//div[contains(text(),'Swag Labs')]")
    WebElement headerText;

    @FindBy(id="user-name")
    WebElement userNameField;

    @FindBy(id="password")
    WebElement passwordField;

    @FindBy(id="login-button")
    WebElement loginBtn;


    public LoginPage(WebDriver driver){
      this.driver = driver;
       PageFactory.initElements(driver,this);
    }

    public boolean navigateToSwagLab() {
        return headerText.isDisplayed();
    }

    public void enterUserName(String name){
        userNameField.sendKeys(name);
    }
    public void enterPassword(String pass){
        passwordField.sendKeys(pass);
    }
    public HomePage clickOnLogIn(){
        loginBtn.click();
        return new HomePage(driver);
    }
   
    
}
