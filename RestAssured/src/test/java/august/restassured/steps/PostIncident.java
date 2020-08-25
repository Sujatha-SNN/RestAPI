package august.restassured.steps;

import java.io.File;

import cucumber.api.java.Before;
import cucumber.api.java.BeforeStep;
import cucumber.api.java.en.And;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class PostIncident {
	public static RequestSpecification request;
	public static Response response;

	

	@And("Pass the data file as (.*) file")
	public void passDataFile(String filename) {
		File file = new File("./data/" + filename);
		request = RestAssured.given().contentType(io.restassured.http.ContentType.JSON).body(file);

	}

	@When("Place the post request")
	public void placePostRequest() {
		response = request.post();
	}

	@Then("Verify the status code as (.*)")
	public void verifyStatusCode(Integer code) {
		response.then().assertThat().statusCode(code);
	}

}
