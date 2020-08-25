package august.restassured.aug18assignment;

import org.testng.annotations.Test;

import august.restassured.base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateCRUsingOAuth2 extends BaseClass {
	@Test
	public void createCRUsingOAuth2() {
		
		loadURL("servicenow");
		Response postResponse = RestAssured
				.given()
				.auth()
				.oauth2("Ny8zXvwDBR584GDG7W4_qrSJJJ82MQG7dHFZ74qfqHxnlyJ7uvKBQfjCqQKcLNPPXJvovfAgV0uuyIHsMVy5sw")
				.contentType(ContentType.JSON)
				.when()
				
				.post();
		System.out.println(postResponse.getStatusCode());
		System.err.println(postResponse.prettyPrint());
	}

}
