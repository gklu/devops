package gov.icdc_runner;

import org.junit.runner.RunWith;

import cucumber.api.CucumberOptions;
import cucumber.api.junit.Cucumber;


@RunWith(Cucumber.class)
@CucumberOptions(plugin= {"html:target/site/cucumber-pretty","json:target/cucumber.json"}, 
features = "./src/test/resources/features",
glue = {"helpers","gov.icdc_step_def"} , 
monochrome = true, tags = {"@Testfooter"}, dryRun =false)
public class Cukes_Runner {

}
