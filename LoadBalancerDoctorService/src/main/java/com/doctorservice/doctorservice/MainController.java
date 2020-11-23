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
	
	private int i = 0;
	
	@GetMapping("/alldoctors")
	private String getdoctors()
	{
		i++;
		return "Counter " + i + " List of doctors new response from port[" + port + "]";
	}
	
	@GetMapping("/location")
	private String getlocation()
	{
		return appName + ":" + port;
	}

}
