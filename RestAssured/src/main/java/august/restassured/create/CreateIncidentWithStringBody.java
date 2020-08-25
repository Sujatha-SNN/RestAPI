package august.restassured.create;

import org.testng.annotations.Test;

import august.restassured.base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class CreateIncidentWithStringBody extends BaseClass{
	@Test
	public void createIncidentWithStringBody()
	{
		RestAssured.baseURI = "https://dev89606.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic(properties.getProperty("username"),properties.getProperty("password"));
		Response postResponse = RestAssured.given()
				.contentType(ContentType.JSON)
		.body("{\"short_description\":\"Created From RA\",\"category\":\"software\"}")
		.post();
		JsonPath jsonRepsonse = postResponse.jsonPath();
		//jsonRepsonse.getList("result.short_description");
		System.err.println(postResponse.prettyPrint());
		System.out.println("Status code"+ postResponse.getStatusCode());
		
		
		
	}

}
