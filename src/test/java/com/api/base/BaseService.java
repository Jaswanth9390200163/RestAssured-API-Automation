package com.api.base;

import static io.restassured.RestAssured.*;			// Static import for RestAssured  increases readability , instead of using RestAssured.given() we can directly use given()

import com.api.filters.LoggingFilter;
import com.api.models.request.LoginRequest;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import io.restassured.specification.RequestSpecification;

public class BaseService {
	
	//responsible for creating BASE URI and other common configurations for all API tests like RequestSpecification, ResponseSpecification, etc.
	
	
	private static final String BASE_URL = "http://64.227.160.186:8080";
	private RequestSpecification requestSpecification;
	
	static{
		// it is instance initializer block which is used to add common filters for all API requests. It adds the LoggingFilter so that all requests and responses will be logged automatically without having to add the filter in each test class.
		filters(new LoggingFilter());
	}
	
	public BaseService() {
		// it is constructor which  Initializes the RequestSpecification (instance variable) with common configurations
		requestSpecification = given().baseUri(BASE_URL);
	}
	
	protected void setAuthToken(String token) {
		// This method is used to set the Authorization header with the token for authenticated requests. It adds the token to the request specification so that it can be used in subsequent API calls that require authentication.
		requestSpecification.header("Authorization", "Bearer " + token);
	}
	
	protected Response postRequest(String endpoint, Object payload) {
		//Object payload is used to make this method more generic and reusable for different types of payloads (not just LoginRequest) and different endpoints.
		//In java Object is the parent class of all classes, so we can pass any type of object as payload and it will be serialized to JSON by RestAssured.
		return requestSpecification.contentType(ContentType.JSON).body(payload).post(endpoint);
	}
	
	protected Response getRequest(String endpoint) {
		return requestSpecification.get(endpoint);
	}
	
	protected Response putRequest(String endpoint, Object payload) {
		return requestSpecification.contentType(ContentType.JSON).body(payload).put(endpoint);
	}

}
