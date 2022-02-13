package runner;

import org.junit.runner.RunWith;

import io.cucumber.junit.CucumberOptions;
import io.cucumber.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(
		        features ="src/test/resources",
		        glue = "step_definitions",
		        plugin = {"pretty", "json:target/report.json"},
		        monochrome = true
)

public class testrunner {
   
}
