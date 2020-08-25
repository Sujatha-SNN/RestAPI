package august.restassured.aug18assignment;

import java.io.File;

import org.testng.annotations.Test;

import august.restassured.base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.http.Header;
import io.restassured.response.Response;

public class CreateJIRAIssue extends BaseClass{
@Test
public void createJiraIssue()
{
	

	loadURL("jira");
	Response postResponse = RestAssured
	.given()
	.header(header)
	.log().all()
	.body(new File("./data/JIRA16-8Assign.json"))
	.accept(ContentType.JSON)
	.when()
	.post();
	id= postResponse.jsonPath().get("id");
	System.err.println("id in CreateJIRAIssue" + id);
	System.out.println("Response Body" + postResponse.body().prettyPrint());
	System.err.println("Status Code" +postResponse.statusCode());
	
}
}
