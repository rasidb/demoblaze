package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class SatınAl_page {
    public SatınAl_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "login2")
    public WebElement login;
    @FindBy(id = "loginusername")
    public WebElement loginUsername;
    @FindBy(linkText = "Sony vaio i5")
    public WebElement ürün;
    @FindBy(linkText = "Add to cart")
    public WebElement sepeteEkleBtn;
    @FindBy(linkText = "Cart")
    public WebElement sepet;
    @FindBy(id = "name")
    public WebElement placeOrderName;
}
