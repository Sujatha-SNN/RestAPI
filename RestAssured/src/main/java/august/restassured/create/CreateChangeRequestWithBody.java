package august.restassured.create;

import java.io.File;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateChangeRequestWithBody {
@Test
	public void createChangeRequest()
	{
		RestAssured.baseURI = "https://dev89606.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "Ask#0106");
		
		Response response = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.queryParam("sysparm_fields", "number,short_description,sys_id")
				.body(new File("./data/CRA1.json"))
				.when()
				.post();
		int statusCode = response.getStatusCode();
		System.out.println(statusCode);
		//System.out.println(response.prettyPeek());
		RestAssured
		.given()
		.log()
		.all()
		.contentType(ContentType.JSON)
		.queryParam("sysparm_fields", "number,short_description,sys_id")
		.body(new File("./data/CRData.json"))
		.post()
		.then()
		.assertThat()
		.statusCode(201);
		;
	}
	
}
