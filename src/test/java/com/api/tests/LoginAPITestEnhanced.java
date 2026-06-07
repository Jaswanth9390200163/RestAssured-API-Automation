package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import static io.restassured.RestAssured.*;			// Static import for RestAssured  increases readability , instead of using RestAssured.given() we can directly use given()
import io.restassured.response.Response;

public class LoginAPITestEnhanced {
	
	@Test(description = "login API optimized Test")
	public void loginTest() {
		System.out.println("Login API Test Optimized");
				
		Response response = given().baseUri("http://64.227.160.186:8080")
				.header("Content-Type", "application/json").body("{\r\n"
						+ "  \"username\": \"jaswanth\",\r\n"
						+ "  \"password\": \"Jaswanth@9999\"\r\n"
						+ "}").post("/api/auth/login");
		
		System.out.println("Response: " + response.asPrettyString());

		Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");

}
	
}
