package BDD.runner;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(
		features = {"src/test/java/BDD/features"},
		plugin = {"pretty", "html:target/cucumber.html"},
		glue={"BDD.stepDefinitions"})

public class TestRunner extends AbstractTestNGCucumberTests {

}
