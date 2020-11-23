package com.doctorservice.doctorservice;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MainController {
	 
	@Value("${spring.application.name:no name}")
	private String appName ;
	
	@Value("${server.port:no port}")
	private String port;
	
	@GetMapping("/doctors")
	private String getdoctors()
	{
		return " doctor manu roshan";
	}
	
	@GetMapping("/location")
	private String getlocation()
	{
		return appName + ":" + port;
	}

}
