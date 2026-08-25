package ua.solvd.cucumber.runner;

import com.zebrunner.carina.cucumber.CucumberBaseTest;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
        features = "src/test/resources/features",
        glue = "ua.solvd.cucumber.step",
        plugin = {"pretty", "html:target/cucumber-reports.html"}
)
public class CucumberWebRunnerTest extends CucumberBaseTest {
}