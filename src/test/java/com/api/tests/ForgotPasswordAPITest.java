package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import com.api.base.AuthService;

import io.restassured.response.Response;

public class ForgotPasswordAPITest {
			
		@Test(description = "Test the forgot password API")
		public void forgotPasswordAPITest() {
			System.out.println("Forgot Password API Test");
			// Implement the test logic for forgot password API here, similar to login test but using the forgotPassword method from AuthService and asserting the expected response.
			
			AuthService authService = new AuthService();
			Response response = authService.forgotPassword("jaswanthalapati1@gmail.com");
			System.out.println("Forgot Password API Test executed successfully");
			
			System.out.println("Response: " + response.asPrettyString());
			Assert.assertEquals(response.asPrettyString(), "If your email exists in our system, you will receive rest instructions.");	// Assert that the response message is as expected to verify that the forgot password functionality is working correctly.
			
		}

}
