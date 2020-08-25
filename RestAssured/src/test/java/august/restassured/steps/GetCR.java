package august.restassured.steps;

import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetCR {
	static Response postResponse;
	@When("Call Get method")
	public void call_Get_method() {
		System.err.println("call_Get_method");
	   postResponse = RestAssured.given()
	   .accept(ContentType.JSON)
	   .when()
	   .get();
	}

	@Then("Check the status code is (.*)")
	public void verify_the_status_code_is_statuscode(Integer statusCode) {
		System.err.println("verify_the_status_code_is_statuscode");
	    postResponse.then()
	    .assertThat().statusCode(statusCode);
	}

}
