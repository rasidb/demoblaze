package com.step_definitions;

import com.pages.Kayıt_page;
import com.utilities.Driver;
import io.cucumber.java.en.And;
import io.cucumber.java.en.Given;
import io.cucumber.java.en.Then;
import io.cucumber.java.en.When;
import org.junit.Assert;
import org.openqa.selenium.Keys;
import org.openqa.selenium.support.ui.ExpectedConditions;
import org.openqa.selenium.support.ui.WebDriverWait;

public class Kayıt_stepDefinition {
    static Kayıt_page page = new Kayıt_page();

    @Given("kullanıcı {string} sitesine gider")
    public void kullanıcı_sitesine_gider(String string) {
        Driver.getDriver().get(string);
    }

    @And("sign up butonuna basar")
    public void signUpButonunaBasar() {
        page.signUpBtn.click();
    }


    @When("kullanıcı {string} ve {string} belirleyerek kayıt işlemini tamamlar")
    public void kullanıcıVeBelirleyerekKayıtIşleminiTamamlar(String kullanıcıAdı, String şifre) {
        page.username.sendKeys(
                kullanıcıAdı + Keys.TAB
                        + şifre + Keys.TAB + Keys.TAB
                        + Keys.ENTER);
        WebDriverWait wait = new WebDriverWait(Driver.getDriver(), 10);
        wait.until(ExpectedConditions.alertIsPresent());
        Assert.assertEquals("Sign up successful.", Driver.getDriver().switchTo().alert().getText());
        Driver.getDriver().switchTo().alert().accept();
    }

    @Then("kullanıcı {string} ve {string} ile giriş yapabilmeli")
    public void kullanıcıVeIleGirişYapabilmeli(String kullanıcıAdı, String şifre) {
        page.login.click();
        page.loginUsername.sendKeys(kullanıcıAdı + Keys.TAB
                + şifre + Keys.TAB + Keys.TAB
                + Keys.ENTER);
    }

    @Then("ekranda welcome yazısı görülmeli")
    public void ekrandaWelcomeYazısıGörülmeli() {
        WebDriverWait wait =new WebDriverWait(Driver.getDriver(),10);
        wait.until(ExpectedConditions.visibilityOf(page.loginCheck));
        Assert.assertTrue(page.loginCheck.isDisplayed());
    }
}
