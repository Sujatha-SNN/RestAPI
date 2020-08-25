package august.restassured.modify;

import org.testng.annotations.Test;

import august.restassured.base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class ModifyUsingPatchForCR extends BaseClass{
	@Test
	public void modifyUsingUsingPatchForCR()
	{
		RestAssured.baseURI = "https://dev89606.service-now.com/api/now/table/change_request/007b96a91b221010d36531d7dc4bcbee";
		RestAssured.authentication = RestAssured.basic(properties.getProperty("username"),properties.getProperty("password"));
		Response putResponse = RestAssured
		.given()
		.contentType(ContentType.JSON)
		
		.log()
		.all()
		.body("{\"short_description\":\"Updated From RA - August\",\"category\":\"software\"}")
		//.pathParam("sys_id", "007b96a91b221010d36531d7dc4bcbee")
		.patch();
		System.out.println(putResponse.getStatusCode());
		System.err.println(putResponse.prettyPrint());
	}

}
