package runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = {"classpath:features"},
        glue = {"stepDefinitions"},
        monochrome = true,
        dryRun = false,
        tags = "@scenario-outline",
        plugin = {"pretty", "html:target/cucumber.html", "json:target/cucumber.json"}
)
public class MainRunner extends AbstractTestNGCucumberTests {
}
