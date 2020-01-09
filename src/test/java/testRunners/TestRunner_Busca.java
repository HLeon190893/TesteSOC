package testRunners;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        features = "C:\\Users\\hugol\\IdeaProjects\\TesteSOC\\features\\Busca.feature",
        glue = { "stepDefinitions" },
        plugin = { "pretty",  "json:target/cucumber-reports/busca-report.json"},
        monochrome = true
)

public class TestRunner_Busca {


}
