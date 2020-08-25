package august.restassured.steps;

import java.io.File;

import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class CreateCR {
	static RequestSpecification requestSpec;
	static Response postResponse;
	@Given("Load URL")
	public void loadURL() {
		System.err.println("loadURL");
		RestAssured.baseURI = "https://dev89606.service-now.com/api/now/table/change_request";
		System.err.println("loadURL" + RestAssured.baseURI);
	}
	
	@Given("Add body using (.*) file")
	public void addBodyUsingCRAFile(String filename) {
		System.out.println("addBodyUsingCRAFile");
		requestSpec = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.body(new File("./data/" + filename))
				.log()
				.all();

	}

	@When("Call Post method")
	public void callPostMethod() {
		postResponse = requestSpec.when().post();
	}

	@Then("Verify the status code is {int}")
	public void verifyTheStatusCodeIs(Integer status) {

		postResponse.then().assertThat().statusCode(status);

	}

}
