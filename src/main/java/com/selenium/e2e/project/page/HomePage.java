package com.selenium.e2e.project.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import com.selenium.e2e.project.BasePage.DriverUtil;



public class HomePage extends DriverUtil {

    @FindBy(xpath="//*[contains(text(),'Products')]")
    WebElement headerText;

    DriverUtil driverUtil;

    @FindBy(className = "product_sort_container")
    WebElement dropdown;

    @FindBy(id = "react-burger-menu-btn")
    WebElement hamburgerBtn;

    @FindBy(id ="about_sidebar_link")
    WebElement aboutLink;


    public HomePage(WebDriver driver){
        super(driver);
        PageFactory.initElements(driver, this);
        driverUtil = new DriverUtil(driver);
    }

    public boolean isHeaderDisplayed(){
       return  headerText.isDisplayed();
    }

    public void selectFromDropdown(String value){
       this.driverUtil.selectByValue(dropdown, value);
    }

    public void clickOnHamBtn(){
       this.driverUtil.click(hamburgerBtn);
    }
    public void clickOnAbt(){
       this. driverUtil.click(aboutLink);
        
    }


    
}
