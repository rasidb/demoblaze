package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;
import org.openqa.selenium.support.ui.WebDriverWait;
import org.w3c.dom.stylesheets.LinkStyle;

import java.util.List;

public abstract class BirdenFazlaUrun_page {
    public BirdenFazlaUrun_page() {
        PageFactory.initElements(Driver.getDriver(), this);
    }

    public int toplamTutar = 0;
    public WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);

    @FindBy(id = "login2")
    public WebElement loginBtn;
    @FindBy(id = "loginusername")
    public WebElement usernameLogin;
    @FindBy(linkText = "Phones")
    public WebElement phones;
    @FindBy(linkText = "Iphone 6 32gb")
    public WebElement phone;
    @FindBy(linkText = "Laptops")
    public WebElement laptops;
    @FindBy(linkText = "Sony vaio i7")
    public WebElement laptop;
    @FindBy(linkText = "Monitors")
    public WebElement monitors;
    @FindBy(linkText = "ASUS Full HD")
    public WebElement monitor;
    @FindBy(linkText = "Cart")
    public WebElement sepet;
    @FindBy(linkText = "Delete")
    public WebElement ürünler;
    @FindBy(xpath = "//div[@class='panel-heading']/h3")
    public WebElement totalPrice;
    @FindBy(xpath = "//button[.='Place Order']")
    public WebElement placeOrder;
    @FindBy(id = "name")
    public WebElement sepetIsim;
    @FindBy(xpath = "//button[.='OK']")
    public WebElement buy;
}
