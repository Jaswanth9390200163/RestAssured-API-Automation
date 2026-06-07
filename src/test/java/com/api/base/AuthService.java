package com.api.base;

import java.util.HashMap;

import com.api.models.request.LoginRequest;
import com.api.models.request.SignupRequest;

import io.restassured.response.Response;

public class AuthService extends BaseService{
	
	private static final String BASE_PATH = "/api/auth/";

	
	public Response login(LoginRequest payload) {
		
		return postRequest(BASE_PATH + "login", payload);
	}
	
	public Response signup(SignupRequest payload) {
		return postRequest(BASE_PATH + "signup", payload);
	}
	
	public Response forgotPassword(String email) {
		HashMap<String, String> payload = new HashMap<>();	// Using a HashMap to create a simple payload with email field for forgot password API.
		payload.put("email", email);
		return postRequest(BASE_PATH + "forgot-password",email);	// Using the postRequest method from BaseService to send a POST request to the forgot password endpoint with the email payload.
	}
}
