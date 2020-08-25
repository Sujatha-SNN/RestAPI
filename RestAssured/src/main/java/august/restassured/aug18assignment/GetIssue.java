package august.restassured.aug18assignment;

import static org.hamcrest.Matchers.containsString;

import org.testng.annotations.Test;

import august.restassured.base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class GetIssue extends BaseClass {
	@Test(dependsOnMethods = "august.restassured.aug18assignment.CreateJIRAIssue.createJiraIssue")
	public void getIssue() {
		loadURL("jira");
		Response response = RestAssured
				.given()
				.accept(ContentType.JSON)
				.pathParam("id", id)
				.when()
				.get("{id}")
				.then()
				.assertThat()
				.body("fields.description",containsString("created"))
				.statusCode(200)
				.extract()
				.response()
				;
		
		System.out.println(response.statusCode());
	}
}

