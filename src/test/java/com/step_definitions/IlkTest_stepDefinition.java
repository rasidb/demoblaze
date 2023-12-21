package com.step_definitions;

import com.utilities.BrowserUtils;
import com.utilities.Driver;
import io.cucumber.java.en.Then;
import org.junit.Assert;

public class IlkTest_stepDefinition {
    @Then("link {string} olmalı")
    public void link_olmalı(String string) {
        Assert.assertEquals("url test et",Driver.getDriver().getCurrentUrl(),string+"1");
    }
}
