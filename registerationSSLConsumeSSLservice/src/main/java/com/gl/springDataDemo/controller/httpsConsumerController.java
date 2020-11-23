package com.gl.springDataDemo.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.gl.springDataDemo.dto.User;
import com.gl.springDataDemo.service.UserService;

@RestController
public class httpsConsumerController {

    Logger logger = LoggerFactory.getLogger("UserManagementApp");

    @Autowired
    private UserService userService;
    
    @Autowired
    RestTemplate temp;

    @GetMapping("/users")
    public List<User> getAllUsers(){
        logger.info("getting users..");
        return userService.findAllUsers();
    }    
}
