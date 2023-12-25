package com.step_definitions;

import com.pages.BirdenFazlaUrun_page;
import com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import org.junit.Assert;
import org.openqa.selenium.By;
import org.openqa.selenium.Keys;
import org.openqa.selenium.WebElement;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class BirdenFazlaUrun_stepDefinition extends BirdenFazlaUrun_page {
    @Given("kullanıcı giris yapar")
    public void kullanıcı_giris_yapar() {
        loginBtn.click();
        usernameLogin.sendKeys("rasid58" + Keys.TAB
                + "4342" + Keys.TAB
                + Keys.TAB + Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.elementToBeClickable(By.id("nameofuser")));
    }

    @And("birkaç ürünü sepete ekler")
    public void birkaçÜrünüSepeteEkler() {
        phones.click();
        phone.click();
        WebElement tutar = Driver.getDriver().findElement(By.className("price-container"));
        toplamTutar += Integer.parseInt(tutar.getText().replaceAll("\\D", ""));
        Driver.getDriver().findElement(By.linkText("Add to cart")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Driver.getDriver().switchTo().alert().accept();
        Driver.getDriver().get("https://demoblaze.com/index.html");

        laptops.click();
        laptop.click();
        tutar = Driver.getDriver().findElement(By.className("price-container"));
        toplamTutar += Integer.parseInt(tutar.getText().replaceAll("\\D", ""));
        Driver.getDriver().findElement(By.linkText("Add to cart")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Driver.getDriver().switchTo().alert().accept();
        Driver.getDriver().get("https://demoblaze.com/index.html");

        monitors.click();
        monitor.click();
        tutar = Driver.getDriver().findElement(By.className("price-container"));
        toplamTutar += Integer.parseInt(tutar.getText().replaceAll("\\D", ""));
        Driver.getDriver().findElement(By.linkText("Add to cart")).click();
        wait.until(ExpectedConditions.alertIsPresent());
        Driver.getDriver().switchTo().alert().accept();
        Driver.getDriver().get("https://demoblaze.com/index.html");
    }

    @Then("ürün ekranıyla sepet fiyat toplamı aynı olmalı")
    public void ürünEkranıylaSepetFiyatToplamıAynıOlmalı() {
        sepet.click();
        wait.until(ExpectedConditions.visibilityOf(ürünler));
        int sepetFiyatı = Integer.parseInt(totalPrice.getText());
        Assert.assertEquals(toplamTutar, sepetFiyatı);
    }

    @Then("satın alma işlemini onaylar")
    public void satınAlmaIşleminiOnaylar() {
        placeOrder.click();
        sepetIsim.sendKeys("rasid" + Keys.TAB
                + "tr" + Keys.TAB
                + "sivas" + Keys.TAB
                + "1234567891" + Keys.TAB
                + "9" + Keys.TAB
                + "2025" + Keys.TAB
                + Keys.TAB + Keys.ENTER);
        wait.until(ExpectedConditions.visibilityOfElementLocated(By.xpath("//h2[.='Thank you for your purchase!']")));
        buy.click();
    }


}
