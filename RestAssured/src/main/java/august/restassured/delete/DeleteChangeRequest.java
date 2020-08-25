package august.restassured.delete;

import org.testng.annotations.Test;

import august.restassured.base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class DeleteChangeRequest extends BaseClass{
	@Test
	public void deleteChangeRequest()
	{
		RestAssured.baseURI = "https://dev89606.service-now.com/api/now/table/change_request/007b96a91b221010d36531d7dc4bcbee";
		RestAssured.authentication = RestAssured.basic(properties.getProperty("username"),properties.getProperty("password"));
		Response putResponse = RestAssured
		.given()
		.contentType(ContentType.JSON)
		
		.log()
		.all()
		
		.delete();
		System.out.println(putResponse.getStatusCode());
		System.err.println(putResponse.prettyPrint());
	}

}
