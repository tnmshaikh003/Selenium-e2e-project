package com.selenium.e2e.project.page;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;


import com.selenium.e2e.project.Util.DriverUtil;



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

    public void selectDropdown(){
        try{
        Select select = new Select(dropdown);
        select.selectByValue("za");
        }catch(Exception e){
            e.printStackTrace();
        }
    }

    public void clickOnHamBtn(){
        try {
            hamburgerBtn.click();
        } catch (Exception e) {
            // TODO: handle exception
            e.getMessage();
        }
    }
    public void clickOnAbt(){
       this. driverUtil.click(aboutLink);
        
    }


    
}
