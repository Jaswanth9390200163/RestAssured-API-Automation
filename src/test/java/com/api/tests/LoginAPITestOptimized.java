package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Listeners;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;


@Listeners(com.api.listeners.TestListenner.class)
public class LoginAPITestOptimized {
	// This class is optimized version of LoginAPITest.java which uses BaseService and AuthService to reduce code duplication and improve maintainability.
	
	@Test(description = "Test the login API")
	public void loginTestOptimized() {
		System.out.println("Login API Test");
		LoginRequest loginRequest = new LoginRequest("jaswanth", "Jaswanth@9999");
		
		AuthService authService = new AuthService();
		Response response = authService.login(loginRequest);
		
		LoginResponse loginResponse = response.as(LoginResponse.class);		// Deserialize the response to LoginResponse class for better readability and maintainability.
		
		System.out.println("Response: " + response.asPrettyString());
		
		System.out.println("Token: " + loginResponse.getToken());		// Print the token from the response to verify that the login was successful and we received a valid token.
		
		System.out.println("Username: " + loginResponse.getUsername());	// Print the username from the response to verify that the login was successful and we received the correct user details.
		
		Assert.assertEquals(loginResponse.getUsername(), "Jaswanth", "Expected username is jaswanth");	// Assert that the username in the response matches the expected username to verify that the login was successful and we received the correct user details.
		Assert.assertEquals(loginResponse.getEmail(), "Jaswanthalapati1@gmail.com", "Email should not be null");	// Assert that the email in the response is not null to verify that we received valid user details in the response.
		Assert.assertEquals(response.getStatusCode(), 200, "Expected status code is 200");	// Assert that the status code of the response is 200 to verify that the login was successful.
		
	}
}