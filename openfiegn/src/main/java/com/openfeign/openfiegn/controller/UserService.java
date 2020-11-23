package com.openfeign.openfiegn.controller;

import java.util.List;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

//@FeignClient(name="feignService",url="http://localhost:8082/")
@FeignClient(name="${service.name}",url="${service.base.url}")
 public interface UserService {
	
	@GetMapping("/user/{id}")
	User getUser(@PathVariable("id") String id);
	
	@PostMapping("/user")
	String addUser(User user);
	
	@DeleteMapping("/user/{id}")
	String deleteUser(@PathVariable("id") String id);
	
	@GetMapping("/users")
	List<User> getUserList();
	
		
	@PutMapping("/user")
	public String UpdateAddress(@RequestBody User user);

}
