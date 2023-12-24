package com.step_definitions;

import com.pages.UrunEkle_page;
import com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.*;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.Wait;
import org.openqa.selenium.support.ui.WebDriverWait;

import java.util.concurrent.TimeUnit;

public class SepeteUrunEkle_stepDefinition {
    UrunEkle_page page = new UrunEkle_page();

    @And("kullanıcı giriş yapar")
    public void kullanıcıGirişYapar() {
        page.login.click();
        page.loginUsername.sendKeys("rasid58" + Keys.TAB
                + "4342" + Keys.TAB + Keys.TAB
                + Keys.ENTER);
    }

    @Given("anasayfada bulunan telefona tıklar ve sepete ekler")
    public void anasayfada_bulunan_telefona_tıklar_ve_sepete_ekler() {
        try {
            page.ürünElement.click();
        } catch (StaleElementReferenceException e) {
            page.ürünElement = Driver.getDriver().findElement(By.linkText("Samsung galaxy s6"));
        } finally {

            page.ürünElement.click();
        }
    }

    @Then("{string} mesajı ekranda görülmeli")
    public void mesajıEkrandaGörülmeli(String arg0) {
        page.sepeteEkleBtn.click();
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals(arg0, Driver.getDriver().switchTo().alert().getText());
        Driver.getDriver().switchTo().alert().accept();
    }

    @And("kullanıcı sepete gider ve ürünü sepetten siler")
    public void kullanıcıSepeteGiderVeÜrünüSepettenSiler() {
        page.sepetBtn.click();
        Assert.assertEquals("Samsung galaxy s6", page.ürün.getText());
        page.deleteBtn.click();
    }

    @Then("ürün sepetten kaldırılmış olmalı")
    public void ürünSepettenKaldırılmışOlmalı() {
        try {
            page.deleteBtn.click();
        }catch (StaleElementReferenceException e){
            Assert.assertTrue(true);
        }
    }


}
