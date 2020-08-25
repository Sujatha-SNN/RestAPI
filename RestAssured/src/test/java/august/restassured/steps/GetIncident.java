package august.restassured.steps;

import cucumber.api.java.en.Given;
import io.restassured.RestAssured;

public class GetIncident {
	@Given("Get  incident from service now")
	public void getIncidentFromServiceNow() {
	    RestAssured.get();
}
}
