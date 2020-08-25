package august.restassured.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.SnippetType;
import cucumber.api.testng.AbstractTestNGCucumberTests;
		
@CucumberOptions(
	features= {"src/test/java/august/restassured/features/incident.feature"},
	glue="august/restassured/steps",
	monochrome=true,snippets= SnippetType.CAMELCASE)

public class RunIncidents  extends AbstractTestNGCucumberTests{

}
