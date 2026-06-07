package com.api.tests;

import org.testng.annotations.Test;

import com.api.base.AuthService;
import com.api.base.UserService;
import com.api.models.request.LoginRequest;
import com.api.models.request.UpdateProfileRequest;
import com.api.models.response.LoginResponse;

import io.restassured.response.Response;

public class UpdateProfileTest {
	
	@Test(description = "Test the update user profile API")
	public void testUpdateUserProfile() {

		//Login to get the token for authentication
		AuthService authService = new AuthService();
		Response response = authService.login(new LoginRequest("jaswanth", "Jaswanth@9999"));
		System.out.println("Login Response: " + response.asPrettyString());
		LoginResponse loginresponse = response.as(LoginResponse.class);
		System.out.println("Token: " + loginresponse.getToken());		// Print the token from the response to verify that the login was successful and we received a valid token.
		
		
		
		// Implement the test logic for updating user profile here, similar to login test but using the updateUserProfile method from UserService and asserting the expected response.
		
		UserService userService = new UserService();

		UpdateProfileRequest updateProfileRequest = new UpdateProfileRequest.Builder()
				.setFirstName("Jaswanth")
				.setLastName("Alapati")
				.setEmail("Jaswanthalapati1@gmail.com")
				.setMobileNumber("1234567899")
				.build();	// Create an instance of UpdateProfileRequest class to hold the payload for updating user profile details.
		
		Response  updateProfileResponse = userService.updateUserProfile(loginresponse.getToken(), updateProfileRequest);	// Call the updateUserProfile method from UserService to send a PUT request to the update profile endpoint with the token for authentication and the payload for updating user profile details.);
		System.out.println("Update Profile Response: " + updateProfileResponse.asPrettyString());
	}
}
