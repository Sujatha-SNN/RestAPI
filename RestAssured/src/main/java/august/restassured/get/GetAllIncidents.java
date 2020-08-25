package august.restassured.get;

import java.util.List;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.path.xml.XmlPath;
import io.restassured.response.Response;

public class GetAllIncidents {
	@Test
	public void getAllIncidents()
	{
		String baseURI = "https://dev89606.service-now.com/api/now/table/incident";
		RestAssured.basic("admin", "Ask#0106");
		Response response = RestAssured
				.given()
				.accept(ContentType.XML)
				.get();
		System.out.println("ResponseCode" + response.getStatusCode());
		response.getContentType();
		response.prettyPrint();
		//TO get the value of a particular field from response
		XmlPath xmlResponse = response.xmlPath();
		List<Object> list = xmlResponse.getList("response.result.number");
		System.out.println(list.size());
		
		
	} 
		
}
