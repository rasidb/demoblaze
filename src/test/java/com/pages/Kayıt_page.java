package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class Kayıt_page {
    public Kayıt_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "signin2")
    public WebElement signUpBtn;
    @FindBy(id="sign-username")
    public WebElement username;
    @FindBy(id = "login2")
    public WebElement login;
    @FindBy(id = "loginusername")
    public WebElement loginUsername;
    @FindBy(id = "nameofuser")
    public WebElement loginCheck;
}
