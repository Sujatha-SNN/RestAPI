package august.restassured.create;

import io.restassured.RestAssured;
import io.restassured.response.Response;

public class CreateIncident {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://dev89606.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Ask#0106");
		Response postResponse = RestAssured
				.given()
				.contentType(io.restassured.http.ContentType.JSON)
				.post();
				
			
		int statusCode = postResponse.getStatusCode();
		System.err.println("statusCode" + statusCode);
		Response prettyPeek = postResponse.prettyPeek();
		System.out.println(prettyPeek.toString());
	}

}
