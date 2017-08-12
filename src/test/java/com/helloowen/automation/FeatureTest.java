package com.helloowen.automation;

import cucumber.api.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(ExtendedCucumberRunner.class)
@CucumberOptions(
        plugin = {"pretty", "json:target/cucumber.json"},
        features = {"src/main/resources/features"},
        glue = {"com.helloowen.automation.steps"},
        tags = {"~@wip", "~@manual"}
)
public class FeatureTest {
}