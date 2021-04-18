import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;


@RunWith(Cucumber.class)
@CucumberOptions(
        features = "src/test/resources/features"
        ,glue={"stepDefinitions"},
        tags="@Sanityz",
        plugin = { "pretty", "html:target/Destination/cucumber.html",
                    "json:target/Destination/cucumber.json",
                    "junit:target/Destination/cucumber.xml",
        },
        monochrome = true
)
public class FlightTest {

}