package com.userManagementClientUsingRest;

import java.net.URI;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

//@SpringBootApplication
public class UserManagementClientUsingRestApplication {

	static RestTemplate restTemplate = new RestTemplate();
	static String baseUrl = "http://localhost:8082/user/5";

	
	public static void main(String[] args) {
		//SpringApplication.run(UserManagementClientUsingRestApplication.class, args);
	
		//useExchange();
		
		addUser();
		//deleteUser();
		
		updateUser();
		
		ForEntityMethodDemo demo = new ForEntityMethodDemo();

		//demo.driverMethod();
	
	}
	
	private static void  useExchange()
	{
		HttpHeaders headers = new HttpHeaders();
		headers.setContentType(MediaType.APPLICATION_JSON);
		
		HttpEntity<Object> requestEntity = new HttpEntity<>(headers); 
		
		ResponseEntity<String> responseEntity =  restTemplate.exchange(baseUrl, HttpMethod.GET , requestEntity ,String.class);
	
		HttpStatus code = responseEntity.getStatusCode();
	
		System.out.println("Status code:" + code);
		
		String user =  responseEntity.getBody();
		
		System.out.println("user response:" + user);
		
		HttpHeaders responseHeaders = responseEntity.getHeaders();
		
		System.out.println("Response Headers:" + responseHeaders);
		
		
		//for object
		
		ResponseEntity<User> responseUser =  restTemplate.exchange(baseUrl, HttpMethod.GET , requestEntity ,User.class);
		
		User userBody = responseUser.getBody();
	
		
		System.out.println("BODY RETURN");
		
		
		System.out.println(userBody.toString());
		System.out.println(userBody.getId());
	}
	
	
	private static void  addUser()
	{
		
		baseUrl = "http://localhost:8082/user";
		
		User addUser = new User();
		addUser.setId("1");
		addUser.setName("Manu Roshan");
		addUser.setAddress("Manu Roshan address");
		
		ResponseEntity<String> responseEntity =  restTemplate.postForEntity(baseUrl, addUser, String.class);
	
		
		addUser.setId("2");
		addUser.setName("jhon");
		addUser.setAddress("jhon address");
		URI path =  restTemplate.postForLocation(baseUrl, addUser, String.class);
		System.out.println("Path" + path);
		
		HttpStatus code = responseEntity.getStatusCode();
	
		System.out.println("Status code:" + code);
		
		String user =  responseEntity.getBody();
		
		System.out.println("user response:" + user);
		
		HttpHeaders responseHeaders = responseEntity.getHeaders();
		
		System.out.println("Response Headers:" + responseHeaders);
		
	}
	
	private static void  deleteUser()
	{
		baseUrl = "http://localhost:8082/user/1";
		
		 restTemplate.delete(baseUrl);
	
		System.out.println("user deleted:");
		
	}
	
	private static void  updateUser()
	{
		baseUrl = "http://localhost:8082/updateuser/1/USA";
		
		 restTemplate.put(baseUrl,null);
	
		System.out.println("updated user:");
		
	}


}
