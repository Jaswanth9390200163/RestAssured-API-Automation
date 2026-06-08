package com.api.tests;


import org.apache.logging.log4j.LogManager;
import org.apache.logging.log4j.Logger;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

import com.github.javafaker.Faker;

import api.endpoints.UserEndPoints2;
import api.payload.User;
import io.restassured.response.Response;

public class UserTests2 {

	Faker faker;
	User userpayload;
	
	public Logger logger;
	
	
	@BeforeClass
	public void  setupdata() {
		
		faker = new Faker();
		userpayload = new User();
		
		userpayload.setId(faker.idNumber().hashCode());
		userpayload.setUsername(faker.name().username());
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		userpayload.setPassword(faker.internet().password(5,10));
		userpayload.setPhone(faker.phoneNumber().cellPhone());
		
		//logs
		
		logger = LogManager.getLogger(this.getClass());
		logger.debug("debugging....");
		
	}
	
	@Test (priority = 1, description = "Create a new user in the system")
	public void testPostUser() {
		
		logger.info("**********Creating User**********");
		Response response = UserEndPoints2.createUser(userpayload);
		
		response.then().log().all();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		logger.info("**********User is created**********");
		
	}
	
	@Test (priority = 2, description = "Get the user created in the system")
	public void testGetUser() {
		
		logger.info("**********Reading User Info**********");
		
		Response response = UserEndPoints2.getUser(this.userpayload.getUsername());
		
		response.then().log().all();
		
		System.out.println(response.statusCode());
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("**********User info is displayed**********");
		
	}
	
	@Test (priority = 3, description = "Update the user created in the system")
	public void updateUser() {
		
		logger.info("**********Updating User Info**********");
		
		//update data using payload
		userpayload.setFirstName(faker.name().firstName());
		userpayload.setLastName(faker.name().lastName());
		userpayload.setEmail(faker.internet().safeEmailAddress());
		
		Response response = UserEndPoints2.updateUser(this.userpayload.getUsername(), userpayload);
		
		response.then().log().body();
		
		Assert.assertEquals(response.getStatusCode(), 200);
		
		//get call  after update
		Response responseafterupdate = UserEndPoints2.getUser(this.userpayload.getUsername());
		Assert.assertEquals(responseafterupdate.getStatusCode(), 200);
		
		logger.info("**********User info is updated**********");
		
	}
	
	@Test (priority = 4, description = "Delete the user created in the system")
	public void deleteUser() {
		
		logger.info("**********Deleting User**********");
		
		Response response = UserEndPoints2.deleteUser(this.userpayload.getUsername());
				
		Assert.assertEquals(response.getStatusCode(), 200);
		
		logger.info("**********User is deleted**********");
	}

}