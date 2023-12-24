package com.step_definitions;

import com.utilities.Driver;
import io.cucumber.java.*;

import org.openqa.selenium.OutputType;
import org.openqa.selenium.TakesScreenshot;


public class Hooks {
    @After
    public void teardownScenario(Scenario scenario) {
        if (scenario.isFailed()) {
            byte[] screenshot = ((TakesScreenshot) Driver.getDriver()).getScreenshotAs(OutputType.BYTES);
            scenario.attach(screenshot, "image/png", scenario.getName());
        }
        Driver.closeDriver();
    }

    @After
    public void afterClass() {
     //   Driver.closeDriver();
    }
    @Before("@heroku")
    public void herokuSetup(){
        Driver.getDriver().get("https://the-internet.herokuapp.com/");
    }
    @Before("@demoblaze")
    public void demoblazeSetup(){
        Driver.getDriver().get("https://demoblaze.com/");
    }
    }


