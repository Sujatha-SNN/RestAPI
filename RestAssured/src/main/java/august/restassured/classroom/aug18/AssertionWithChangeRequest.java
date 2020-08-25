package august.restassured.classroom.aug18;

import java.io.File;


import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.response.ValidatableResponse;
import static org.hamcrest.Matchers.containsString;

public class AssertionWithChangeRequest {
	@Test
	public void createChangeRequest()
	{
		
		RestAssured.baseURI = "https://dev89606.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "Ask#0106");
		
		
		/*//This is the response type returned when assert that is used
		ValidatableResponse statusCode2 = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.queryParam("sysparm_fields", "number,short_description,sys_id")
				.body(new File("./data/CRData.json"))
				.post()
				.then()
				.assertThat()
				.statusCode(201);
		*/
		//To use the normal response use extract method and reponse methods
		
		Response response = RestAssured
			.given()
			.contentType(ContentType.JSON)
			.queryParam("sysparm_fields", "number,short_description,sys_id")
			.body(new File("./data/CRData.json"))
			.post()
			.then()
			.assertThat()
			.body("result.short_description",containsString("created"))
			.statusCode(201)
			.extract()
			.response();
		int statusCode = response.getStatusCode();
		String  desc = response.jsonPath().get("result.short_description");
		System.out.println(statusCode);
		System.err.println(desc);
		
		System.out.println(response.prettyPeek());
	}

}
