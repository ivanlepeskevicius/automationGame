package Runner;


import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;



@CucumberOptions(features = {"src/main/java/Features"},
        format = {"json:target/report.json", "html:target/site/cucumber-report"}, glue = "Steps")

public class TestRunner extends AbstractTestNGCucumberTests{
}
