package august.restassured.create;

import java.io.File;

import org.testng.annotations.DataProvider;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class CreateIncidentWithMultipleData {

	@DataProvider
	public String[] getData() {
		String[] data = new String[2];
		data[0]= "./data/IncData1.json";
		data[1] ="./data/IncData2.json";
		return data;
		
	}
		
		@Test(dataProvider="getData")
		public void createChangeRequest(String file)
		{
			RestAssured.baseURI = "https://dev89606.service-now.com/api/now/table/incident";
			RestAssured.authentication = RestAssured.basic("admin", "Ask#0106");
			
			Response response = RestAssured
					.given()
					.contentType(ContentType.JSON)
					.queryParam("sysparm_fields", "number,short_description,sys_id")
					.body(new File(file))
					.post();
			int statusCode = response.getStatusCode();
			System.out.println(statusCode);
			System.out.println(response.prettyPeek());
		}

	

}
