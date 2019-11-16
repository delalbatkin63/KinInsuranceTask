package runners;


import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
        plugin = {"html:target/cucumberreports", "json:target/report.json"},
        features = "src/test/resources/features",
        glue = "steps",
        tags = "@LittlefoodLibraryTest",
        dryRun = false
)
public class Runner {

}
