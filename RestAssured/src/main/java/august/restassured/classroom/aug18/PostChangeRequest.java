package august.restassured.classroom.aug18;

import org.testng.annotations.Test;

import august.restassured.base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostChangeRequest extends BaseClass {
	@Test
	public void postNewChangeRequest() {
		RestAssured.baseURI = properties.getProperty("servicenowmineCR");
		RestAssured.authentication = RestAssured.basic(properties.getProperty("username"),properties.getProperty("password"));
		
		Response postResponse = RestAssured.given().contentType(io.restassured.http.ContentType.JSON).post();

		int statusCode = postResponse.getStatusCode();
		System.err.println("statusCode" + statusCode);
		// Response prettyPeek = postResponse.prettyPeek();
		// System.out.println(prettyPeek.toString());

		JsonPath jsonReponse = postResponse.jsonPath();
		sys_id = jsonReponse.get("result.sys_id");
		System.err.println("sys_id" + sys_id);
	}
}
