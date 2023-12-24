package com.pages;

import com.utilities.Driver;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.FindBy;
import org.openqa.selenium.support.PageFactory;

public class UrunEkle_page {
    public UrunEkle_page(){
        PageFactory.initElements(Driver.getDriver(),this);
    }
    @FindBy(id = "login2")
    public WebElement login;
    @FindBy(id = "loginusername")
    public WebElement loginUsername;
    @FindBy(linkText = "Samsung galaxy s6")
    public WebElement ürünElement;
    @FindBy(linkText = "Add to cart")
    public WebElement sepeteEkleBtn;
    @FindBy(id = "cartur")
    public WebElement sepetBtn;
    @FindBy(xpath = "(//tbody[@id='tbodyid']//td)[2]")
    public WebElement ürün;
    @FindBy(linkText = "Delete")
    public WebElement deleteBtn;
}
