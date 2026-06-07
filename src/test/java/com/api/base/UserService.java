package com.api.base;

import io.restassured.response.Response;

public class UserService extends BaseService {
	
	private static final String BASE_PATH = "/api/users/";
	
	public Response getUserProfile(String token) {
		setAuthToken(token);	// Setting the Authorization token in the request specification using the setAuthToken method from BaseService to authenticate the request for getting user profile details.
		return getRequest(BASE_PATH + "profile");
	}
	
	public Response updateUserProfile(String token, Object payload) {
		setAuthToken(token);	// Setting the Authorization token in the request specification using the setAuthToken method from BaseService to authenticate the request for updating user profile details.
		return putRequest(BASE_PATH + "profile", payload);
	}

}
