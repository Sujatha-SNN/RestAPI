package august.restassured.base;

import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.Properties;

import org.testng.annotations.BeforeClass;
import org.testng.annotations.BeforeMethod;
import org.testng.annotations.BeforeTest;
import org.testng.annotations.Parameters;

import io.restassured.RestAssured;
import io.restassured.http.Header;

public class BaseClass {
	public static Properties properties = null;
	public static String sys_id,id;
	public static Header header;

	@BeforeTest
	public static void loadCredentials() throws FileNotFoundException, IOException {
		properties = new Properties();
		properties.load(new FileInputStream(new File("./repository/credentials.properties")));
	}
	
	
	
	public static void loadURL(String serviceName)
	{
		if(serviceName.equalsIgnoreCase("jira"))
		{
			RestAssured.baseURI="https://api-may2020.atlassian.net/rest/api/2/issue/";
			RestAssured.authentication= RestAssured.preemptive().basic("hari.radhakrishnan@testleaf.com", "60beSkCr05XHzsMLUfVYD8A7");
			 header = new Header("Content-Type", "application/json");
		}
		else if(serviceName.equalsIgnoreCase("servicenow")){
			RestAssured.baseURI=properties.getProperty("servicenowmineCR");
			RestAssured.authentication= RestAssured.basic("admin", "Ask#0106");
			 header = new Header("Content-Type", "application/json");
		}
		
		
	}
}
