package com.userManagementClientUsingRest;


import java.util.List;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.client.RestTemplate;

public class ForEntityMethodDemo 
{
	
	static RestTemplate restTemplate = new RestTemplate();
	static String baseUrl = "http://localhost:8082/user/5";
	
	public void driverMethod()
	{
		getSingleObject();
		getListObject();
	}
	
	void getSingleObject()
	{
		  baseUrl = "http://localhost:8082/user/5";
		
		System.out.println("getSingleObject is called");
		ResponseEntity<String> responseEntity =  restTemplate.getForEntity(baseUrl, String.class);
		
		HttpStatus code = responseEntity.getStatusCode();
	
		System.out.println("Status code:" + code);
		
		String user =  responseEntity.getBody();
		
		System.out.println("user response:" + user);
		
		HttpHeaders responseHeaders = responseEntity.getHeaders();
		
		System.out.println("Response Headers:" + responseHeaders);
	}
	
	void getListObject()
	{
		 baseUrl = "http://localhost:8082/users";
		
		System.out.println("getSingleObject is called");
		ResponseEntity<List> responseEntity =  restTemplate.getForEntity(baseUrl, List.class);
		
		HttpStatus code = responseEntity.getStatusCode();
	
		System.out.println("Status code:" + code);
		
		List<Object> users =  responseEntity.getBody();
		
		System.out.println("user response:" + users);
		
		HttpHeaders responseHeaders = responseEntity.getHeaders();
		
		System.out.println("Response Headers:" + responseHeaders);
	}

}
