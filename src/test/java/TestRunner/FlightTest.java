package TestRunner;

import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features"
        ,glue={"stepDefinitions"},
        tags="@test",
        plugin = { "pretty", "html:target/CucumberReport/cucumber.html",
                "json:target/CucumberReport/cucumber.json",
                "junit:target/CucumberReport/cucumber.xml",
        }
)
public class FlightTest {

}