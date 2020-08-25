package august.restassured.runner;

import cucumber.api.CucumberOptions;
import cucumber.api.testng.AbstractTestNGCucumberTests;

@CucumberOptions(
features={"src/test/java/august/restassured/features/createchangerequest.feature"
		,"src/test/java/august/restassured/features/getchangerequest.feature"},
glue="august/restassured/steps",
monochrome=true,
plugin= {"pretty", "html:target"})

public class RunChangeRequest extends AbstractTestNGCucumberTests {
	


}
