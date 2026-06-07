package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserService;
import com.api.models.request.LoginRequest;
import com.api.models.response.LoginResponse;
import com.api.models.response.UserProfileResponse;

import io.restassured.response.Response;

public class GetProfileAPITest {
	
	@Test(description = "Test the get profile API")
	public void getProfileAPITest() {
		System.out.println("Get Profile API Test");
		
		
		//we have to login first to get the token and then we can use that token to get the profile details. 
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("jaswanth", "Jaswanth@9999"));
		
		LoginResponse loginresponse = response.as(LoginResponse.class);
		
		System.out.println("token is :" + loginresponse.getToken());
		
		// Implement the test logic for get profile API here, using the UserService to send a GET request to the profile endpoint and asserting the expected response to verify that the get profile functionality is working correctly.
		
		UserService userService = new UserService();
		Response response1 = userService.getUserProfile(loginresponse.getToken());	// Using the getUserProfile method from UserService to send a GET request to the profile endpoint with the token obtained from the login response.
		System.out.println("Get Profile API Test executed successfully");
		
		System.out.println("Response1: " + response1.asPrettyString());
		UserProfileResponse userProfileResponse = response1.as(UserProfileResponse.class);	// Deserialize the response to UserProfileResponse class for better readability and maintainability.
		
		System.out.println("Username: " + userProfileResponse.getUsername()); //print the username from the profile response to verify that we received the correct user details in the profile response.
		
		Assert.assertEquals(response1.getStatusCode(), 200);	// Assert that the status code is 200 to verify that the get profile API is working correctly and returning the expected response.
		
	}

}
