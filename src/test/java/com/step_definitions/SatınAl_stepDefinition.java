package com.step_definitions;

import com.pages.SatınAl_page;
import com.utilities.BrowserUtils;
import com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.StaleElementReferenceException;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class SatınAl_stepDefinition {
 SatınAl_page page =new SatınAl_page();
    @Given("Kullanıcı giriş yapar")
    public void kullanıcı_giriş_yapar() {
        page.login.click();
        page.loginUsername.sendKeys("rasid58" + Keys.TAB
                + "4342" + Keys.TAB + Keys.TAB
                + Keys.ENTER);
    }

    @And("sepete ürün ekler")
    public void sepeteÜrünEkler() {
        BrowserUtils.scrollByJs(page.ürün);
       try {
           page.ürün.click();
       }catch (StaleElementReferenceException e){
           page.ürün = Driver.getDriver().findElement(By.linkText("Sony vaio i5"));
           page.ürün.click();
       }
        page.sepeteEkleBtn.click();
        WebDriverWait wait =new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.alertIsPresent());
        Driver.getDriver().switchTo().alert().accept();
        page.sepet.click();
    }

    @And("{string} butonuna basarak sipariş için gerekli formu doldurur")
    public void butonunaBasarakSiparişIçinGerekliFormuDoldurur(String arg0) {
        Driver.getDriver().findElement(By.xpath("//button[.='"+arg0+"']")).click();
        page.placeOrderName.sendKeys("rasid"+Keys.TAB
        +"tr"+Keys.TAB
        +"sivas"+Keys.TAB
        +"1234567891"+Keys.TAB
        +"9"+Keys.TAB
        +"2023"+Keys.TAB
        +Keys.TAB+Keys.ENTER);
    }

    @Then("siparis tamamlanmıs olmalı")
    public void siparisTamamlanmısOlmalı() {
        Assert.assertTrue(Driver.getDriver().findElement(By.xpath("//h2[.='Thank you for your purchase!']")).isDisplayed());
    }
}
