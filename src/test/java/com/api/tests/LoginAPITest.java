package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import io.restassured.RestAssured;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class LoginAPITest {
	
	@Test(description = "Test the login API")
	public void loginTest() {
		System.out.println("Login API Test");
		
		RestAssured.baseURI = "http://64.227.160.186:8080";
		
		RequestSpecification r = RestAssured.given();
		RequestSpecification h = r.header("Content-Type", "application/json");
		RequestSpecification b = h.body("{\r\n"
				+ "  \"username\": \"jaswanth\",\r\n"
				+ "  \"password\": \"Jaswanth@9999\"\r\n"
				+ "}");
		
		Response response = b.post("/api/auth/login");
		System.out.println("Response: " + response.asPrettyString());
		
		Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");
	}

}
