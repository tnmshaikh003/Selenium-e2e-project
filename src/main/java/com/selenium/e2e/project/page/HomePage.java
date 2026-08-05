package com.selenium.e2e.project.page;

import java.time.Duration;

import org.openqa.selenium.WebDriver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.Select;
import org.openqa.selenium.support.ui.WebDriverWait;

import com.selenium.e2e.project.Util.DriverUtil;



public class HomePage  {

    @FindBy(xpath="//*[contains(text(),'Products')]")
    WebElement headerText;

    WebDriver driver;
    DriverUtil driverUtil;

    @FindBy(className = "product_sort_container")
    WebElement dropdown;

    @FindBy(id = "react-burger-menu-btn")
    WebElement hamburgerBtn;

    @FindBy(id ="about_sidebar_link")
    WebElement aboutLink;

    private WebDriverWait wait;

    public HomePage(WebDriver driver){
        this.driver = driver;
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
        driverUtil.click(aboutLink);
        
    }


    
}
