package Runners;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;
import org.testng.annotations.DataProvider;

@CucumberOptions(
        features = "src/test/resources",
        glue = {"steps"},
        plugin = {"pretty","html:target/reports"}
)
public class TestRunner extends AbstractTestNGCucumberTests {
}
