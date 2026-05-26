package base;

import org.testng.annotations.BeforeClass;

import io.restassured.RestAssured;

public class BaseClass {
	@BeforeClass
	public void setup() {
		
		//for automation website
		//RestAssured.baseURI="https://automationexercise.com/";
		
		//for faker website
		RestAssured.baseURI="https://fakestoreapi.com/";
	}

}
