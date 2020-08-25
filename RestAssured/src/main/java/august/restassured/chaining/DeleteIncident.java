package august.restassured.chaining;

import org.testng.annotations.Test;

import august.restassured.base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteIncident extends BaseClass {
	@Test(dependsOnMethods="august.restassured.chaining.PostNewIncident.postNewIncident")
	public void deleteIncidentChangeRequest()
	{
		RestAssured.baseURI = "https://dev89606.service-now.com/api/now/table/incident/";
		RestAssured.authentication = RestAssured.basic(properties.getProperty("username"),properties.getProperty("password"));
		Response putResponse = RestAssured
		.given()
		.contentType(ContentType.JSON)
		
		.log()
		.all()
		.pathParam("sys_id", sys_id)
		.delete("{sys_id}");
		System.out.println(putResponse.getStatusCode());
		//System.err.println(putResponse.prettyPrint());
	}
}
