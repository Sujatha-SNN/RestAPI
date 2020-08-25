package august.restassured.steps;

import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import io.restassured.RestAssured;

public class Hooks {
	
	@Before("@Incident")
	@Given("Setup the base URI for incident api")
	public void setUpURI() {
		System.out.println("Inside setup URI");
		RestAssured.baseURI = "https://dev89606.service-now.com/api/now/table/incident";
	}

	
	@And("Authentication with valid credentials")
	public void setUpAuthentication() {
		System.err.println("setUpAuthentication");
		RestAssured.authentication = RestAssured.basic("admin", "Ask#0106");
	}
	
	
	

	
}
