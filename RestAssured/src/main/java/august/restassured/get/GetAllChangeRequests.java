package august.restassured.get;

import java.util.List;

import io.restassured.RestAssured;
import io.restassured.http.ContentType;
import io.restassured.path.json.JsonPath;
import io.restassured.response.Response;

public class GetAllChangeRequests {

	public static void main(String[] args) {
		RestAssured.baseURI = "https://dev89606.service-now.com/api/now/table/change_request";
		RestAssured.authentication = RestAssured.basic("admin", "Ask#0106");
		
		Response response = RestAssured.given()
				.queryParam("sysparm_fields", "number,short_description,sys_id")
				.accept(ContentType.JSON).get();
		String prettyPrint = response.prettyPrint();
		System.out.println(response.getStatusCode() + response.getContentType());
		JsonPath jsonReponse = response.jsonPath();
		List<Object> list = jsonReponse.getList("result.number");
		System.out.println(list.size()+ "" + list.get(0));
		
		
	}
}