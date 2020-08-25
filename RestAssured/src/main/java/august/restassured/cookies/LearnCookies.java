package august.restassured.cookies;

import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.response.Response;

public class LearnCookies {

	/*@Test
	public void getCookies() {
		RestAssured.baseURI = "https://dev89606.service-now.com/api/now/table/incident";
		RestAssured.authentication = RestAssured.basic("admin", "Ask#0106");
		Response postResponse = RestAssured.given().contentType(ContentType.JSON).log().all().when().post();
		
		 * Map<String, String> cookies = postResponse.getCookies(); Set<Entry<String,
		 * String>> entrySet = cookies.entrySet(); System.out.println(entrySet.size());
		 * for (Entry<String, String> entry : entrySet) {
		 * System.out.println(entry.getKey()) ; System.out.println(entry.getValue());
		 * 
		 * }
		 
		System.out.println(postResponse.getStatusCode());
		System.out.println(postResponse.cookie("JSESSIONID"));
		System.err.println(postResponse.sessionId());
		Response response = RestAssured.given().contentType(io.restassured.http.ContentType.JSON).get();
		System.out.println(response.getSessionId());

	}
*/
	@Test
	public void getCookiesUsage()
	{
		RestAssured.baseURI = "https://dev89606.service-now.com/api/now/table/incident";
		//RestAssured.authentication = RestAssured.basic("admin", "Ask#0106");
		Response postResponse = RestAssured
				.given()
				.contentType(ContentType.JSON)
				.auth()
				.basic("admin", "Ask#0106")
				.log()
				.all()
				.when()
				.post();
		/*Map<String, String> cookies = postResponse.getCookies();
		Set<Entry<String, String>> entrySet = cookies.entrySet();
		System.out.println(entrySet.size());
		for (Entry<String, String> entry : entrySet) {
			System.out.println(entry.getKey()) ;
			System.out.println(entry.getValue());
			
		}*/
		System.out.println(postResponse.getStatusCode());;
		String cookie = postResponse.cookie("JSESSIONID");
		System.out.println(postResponse.cookie("JSESSIONID"));
		System.err.println(postResponse.sessionId());
		Response response = RestAssured
				.given()
				.cookie("JSESSIONID" , cookie)
				.contentType(io.restassured.http.ContentType.JSON)
				.get();
		System.out.println(response.jsonPath().getList("result.number").get(0));
		
		
	
	}
}
