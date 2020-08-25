package august.restassured.chaining;

import org.testng.annotations.Test;

import august.restassured.base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class PostNewIncident extends BaseClass{
	@Test
	public  void postNewIncident() {
		RestAssured.baseURI = "https://dev89606.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Ask#0106");
		Response postResponse = RestAssured
				.given()
				.contentType(io.restassured.http.ContentType.JSON)
				.post();
				
			
		int statusCode = postResponse.getStatusCode();
		System.err.println("statusCode" + statusCode);
		Response prettyPeek = postResponse.prettyPeek();
		//System.out.println(prettyPeek.toString());
		
		JsonPath jsonReponse = postResponse.jsonPath();
		id = jsonReponse.get("result.id");
		System.err.println("id" + id);
	}
}
