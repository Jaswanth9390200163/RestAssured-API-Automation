package api.endpoints;

import io.restassured.http.ContentType;
import io.restassured.response.Response;
import static io.restassured.RestAssured.given;

import java.util.ResourceBundle;

import api.payload.User;

/* CRUD operations for User Module
 * 
 */


public class UserEndPoints2 extends Routes {
	
	static ResourceBundle getURL() {
		ResourceBundle routes = ResourceBundle.getBundle("routes"); // Load the properties file
		return routes;
	}
	
	 public static Response createUser(User Payload) {
		 
		String post_url =  getURL().getString("post_url");	 
		
		Response response = given()
			.contentType(ContentType.JSON)
			.accept(ContentType.JSON)
			.body(Payload)
			
		.when()
			.post(post_url);
		
		return response;
	}
	 
	 public static Response getUser(String username) {
		 
		 String get_url = getURL().getString("get_url");
			
			Response response = given()
					.pathParam("username",username)
					
					.when()
					.get(get_url);
			
			return response;
	 }
	 
	 public static Response updateUser(String username, User payload) {
		 
		 String put_url = getURL().getString("put_url");

		 
		 Response response = given()
				 .contentType(ContentType.JSON)
				 .accept(ContentType.JSON)
				 .pathParam("username", username)
				 .body(payload)
				 
				 .when()
				 .put(put_url);
		 
		return response;
	 }
	 
	 public static Response deleteUser (String username) {
		 
		 String delete_url = getURL().getString("delete_url");
		 
		 Response response = given()
				 .pathParam("username", username)
				 
				 .when()
				 .delete(delete_url);
		 
		 return response;
	 }
}
