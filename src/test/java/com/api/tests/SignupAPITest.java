package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.models.request.SignupRequest;

import io.restassured.response.Response;

public class SignupAPITest {
	
	@Test(description = "Test the signup API")
	public void signupAPITest() {
		System.out.println("Signup API Test");
		// Implement the test logic for signup API here, similar to login test but using SignupRequest and SignupResponse classes.
		
		SignupRequest signupRequest = new SignupRequest.Builder()
				.setUsername("newuser1234")
				.setPassword("NewUser@1234")
				.setEmail("newuserr1234@gmail.com")
				.setFirstName("New")
				.setLastName("User")
				.setMobileNumber("1234567890").build();
		
		AuthService authService = new AuthService();
		Response response = authService.signup(signupRequest);
		System.out.println("Signup API Test executed successfully");
		
		System.out.println("Response: " + response.asPrettyString());
		
		Assert.assertEquals(response.asPrettyString(), "User registered successfully!");	// Assert that the status code of the response is 201 to verify that the signup was successful.

	}

}
