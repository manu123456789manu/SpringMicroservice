package com.openfeign.openfiegn.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class MainController {

	@Autowired
	UserService UserService;

	@GetMapping("/user/{id}")
	User  getUsers(@PathVariable String id)
	{
		return UserService.getUser(id);
	}
	
	@GetMapping("/users")
	List<User>  getUsers()
	{
		return UserService.getUserList();
	}
	
	@PostMapping("user")
	public String addUser(@RequestBody User user)
	{
		return UserService.addUser(user);
	}
	
	@DeleteMapping("/user/{id}")
	public String deleteUser(@PathVariable String id)
	{
		return UserService.deleteUser(id);
	}
	
	/*
	 * The body part is added in the request postman body type as json 	
	 */
	@PutMapping("/user")
	public String updateUser(@RequestBody User user)
	{
		return UserService.UpdateAddress(user);
	}

}
