package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\hugol\\IdeaProjects\\TesteSOC\\features\\FAP.feature",
        glue = { "stepDefinitions" },
        plugin = { "pretty",  "json:target/cucumber-reports/fap-report.json"},
        monochrome = true
)

public class TestRunner_FAP {

}
