package august.restassured.aug18assignment;

import java.io.File;
import java.util.ArrayList;
import java.util.List;

import org.testng.annotations.Test;

import august.restassured.base.BaseClass;
import io.restassured.RestAssured;
import io.restassured.http.Header;
import io.restassured.http.Headers;
import io.restassured.response.Response;

public class AttachFileToJIRAIssue extends BaseClass {
	@Test(dependsOnMethods = "august.restassured.aug18assignment.CreateJIRAIssue.createJiraIssue")
	public void attachFileToJIRAIssue() {
		loadURL("attachimgtojiraissue");
		List<Header> listHeader = new ArrayList<Header>();
		listHeader.add(new Header("Content-Type", "multipart/form-data"));
		listHeader.add(new Header("X-Atlassian-Token", "no-check"));
		Headers headers = new Headers(listHeader);

		Response response = RestAssured
				.given()
				.headers(headers)
				.multiPart(new File("./images/SSN.jpeg"))
				.pathParam("id", id)
				.when()
				.post("{id}/attachments");
		System.out.println(response.statusCode());

	}

}
