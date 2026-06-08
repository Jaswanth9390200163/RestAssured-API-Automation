package com.api.tests;

import org.testng.Assert;
import org.testng.annotations.Test;

import api.endpoints.UserEndPoints;
import api.payload.User;
import com.api.utilities.DataProviders;
import io.restassured.response.Response;

public class DataDrivenTests {
	
	@Test(priority=1 , dataProvider="Data", dataProviderClass=DataProviders.class)
	public void testPostUser(String id, String username, String firstName, String lastName, String email, String password, String phone) {
		
		System.out.println(id + " " + username + " " + firstName + " " + lastName + " " + email + " " + password + " " + phone);
		
		User userpayload = new User();
		
		userpayload.setId(Integer.parseInt(id));
		userpayload.setUsername(username);
		userpayload.setFirstName(firstName);
		userpayload.setLastName(lastName);
		userpayload.setEmail(email);
		userpayload.setPassword(password);
		userpayload.setPhone(phone);
		
		
		Response response = UserEndPoints.createUser(userpayload);
				
		Assert.assertEquals(response.getStatusCode(), 200);
		
		
	}
	
	@Test(priority=2, dataProvider="UserNames", dataProviderClass=DataProviders.class)
	public void testdeleteUserByName(String username) {
		
		Response response = UserEndPoints.deleteUser(username);
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
	}

}
