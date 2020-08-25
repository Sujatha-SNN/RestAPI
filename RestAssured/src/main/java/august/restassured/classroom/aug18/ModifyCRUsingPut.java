package august.restassured.classroom.aug18;

import org.testng.annotations.Test;

import august.restassured.base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ModifyCRUsingPut extends BaseClass{
	@Test(dependsOnMethods="august.restassured.chaining.PostChangeRequest.postNewChangeRequest")
	public void modifyUsingPutForCR()
	{
		RestAssured.baseURI = properties.getProperty("servicenowmineCR");
		RestAssured.authentication = RestAssured.basic(properties.getProperty("username"),properties.getProperty("password"));
		Response putResponse = RestAssured
		.given()
		.contentType(ContentType.JSON)
		
		.log()
		.all()
		.body("{\"short_description\":\"Updated From RA - August\",\"category\":\"inquiry\"}")
		.pathParam("sys_id", sys_id)
		.put("{sys_id}");
		System.out.println(putResponse.getStatusCode());
		//System.err.println(putResponse.prettyPrint());
	}
}
