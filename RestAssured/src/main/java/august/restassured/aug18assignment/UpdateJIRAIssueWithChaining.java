package august.restassured.aug18assignment;

import org.testng.annotations.Test;

import august.restassured.base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class UpdateJIRAIssueWithChaining extends BaseClass{
	@Test(dependsOnMethods="august.restassured.aug18assignment.CreateJIRAIssue.createJiraIssue")
	public void UupdateJIRAIssueWithChaining()
	{		
		
		loadURL("jira");
		Response putRepsonse = RestAssured.given()
		.contentType(ContentType.JSON)
		.body("{\"fields\": { \"summary\": \"Update on august 17-8-2020 Using REST API for testing\"  }}")
		.when()
		.pathParam("id", id)
		.log()
		.all()
		.put("{id}");
		System.out.println(putRepsonse.statusCode());
		
	}

}
