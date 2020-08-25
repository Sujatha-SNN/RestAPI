package august.restassured.aug18assignment;

import org.testng.annotations.Test;

import august.restassured.base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchemaInClasspath;
import static io.restassured.module.jsv.JsonSchemaValidator.matchesJsonSchema;

public class SNSchemaValidationForPost extends BaseClass{
@Test
public void schemaValidationForPost()
{
	try {
		loadURL("servicenow");
		Response response = RestAssured.given()
		.contentType(ContentType.JSON)
		.body("{\"short_description\":\"Created From RA\",\"category\":\"software\"}")
		.when()
		.post()
		.then()
		.assertThat()
		.body(matchesJsonSchema("./data/schema.json"))
		.log()
		.all()
		.extract()
		.response();
	
	} catch (Exception e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		
	} 
	
}
}
