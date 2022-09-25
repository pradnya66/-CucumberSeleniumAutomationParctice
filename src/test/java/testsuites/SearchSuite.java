package testsuites;

import io.cucumber.testng.AbstractTestNGCucumberTests;
import io.cucumber.testng.CucumberOptions;

@CucumberOptions(features="features/automationPracticeSearchString.feature", glue="Steps",
					plugin= {"html:target/cucumber-html-report"})

public class SearchSuite extends AbstractTestNGCucumberTests{

}
