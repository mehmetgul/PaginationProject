package assessment;


import io.cucumber.junit.Cucumber;
import io.cucumber.junit.CucumberOptions;
import org.junit.runner.RunWith;

@RunWith(Cucumber.class)
@CucumberOptions(
		strict = true,
		dryRun =false,
		features = "src/test/resources/features",
		glue = "assessment.stepDef",
		//tags = "@someTag",
		plugin = {"html:target/default-cucumber-reports",
				"json:target/cucumber.json"
		}
)
public class Runner {
}
