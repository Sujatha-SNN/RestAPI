package august.restassured.modify;

import org.testng.annotations.Test;

import august.restassured.base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ModifyUsingPutForIncident  extends BaseClass{
@Test
	public void modifyUsingPutForIncident()
	{
		RestAssured.baseURI = "https://dev89606.service-now.com/api/now/table/incident/";
		RestAssured.authentication = RestAssured.basic(properties.getProperty("username"),properties.getProperty("password"));
		Response putResponse = RestAssured
		.given()
		.contentType(ContentType.JSON)
		
		.log()
		.all()
		.body("{\"short_description\":\"Updated From RA - August\",\"category\":\"inquiry\"}")
		.pathParam("sys_id", "f94d72071be21010d36531d7dc4bcb9d")
		.put("{sys_id}");
		System.out.println(putResponse.getStatusCode());
		System.err.println(putResponse.prettyPrint());
	}
}
