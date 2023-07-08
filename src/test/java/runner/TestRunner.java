package runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

/* -TestRunner Class
 * -features: the path of the feature files 
 * -glue: the path of the step definition files
 * -tags: tags which need to be execute.
 * -monochrome: display the console output in a proper readable format
 * -dryRun: to check the mapping is proper between feature file and step definition file
 */

@CucumberOptions(features = "src/test/resources/features", glue = "stepDefinitions", //
		plugin = { "pretty", "html:target/html_reports/cucumber-reports.html", "json:target/cucumber.json" },
		// tags = "@p1", publish = true,
		monochrome = true, publish = true, dryRun = false)

public class TestRunner extends AbstractTestNGCucumberTests {

}