package com.doctorservice.doctorservice;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {
	
	@Autowired
	RestTemplate resttemplate;
	 
	@SuppressWarnings("unchecked")
	@GetMapping("/userslistrest")
	List<User>  getUsers()
	{
		//for normal settings
		//return (List<User>)resttemplate.getForObject("http://localhost:8082/users", List.class);
		
		return (List<User>)resttemplate.getForObject("/users", List.class);
	}

}
