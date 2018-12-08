package au.com.cuke.ui.core;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features={"src/test/features"},
        glue = {"au.com.cuke.ui.stepDefinition"},
        plugin = {"json:target/cucumber.json"}
    )

public class RunCukes {
}