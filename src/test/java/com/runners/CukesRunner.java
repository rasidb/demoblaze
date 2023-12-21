package com.runners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features",
        glue = "com.step_definitions",
        plugin = {
                "html:target/cucumber-reports/report.html",
                "rerun:target/cucumber-reports/rerun.txt",
                "me.jvt.cucumber.report.PrettyReports:target/cucumber-reports"
        },
        tags = "@heroku",
        dryRun = false,
        publish = true

)
public class CukesRunner {

}