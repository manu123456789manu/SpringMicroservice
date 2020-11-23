package com.loadbalancerserver.loadbalancerserver;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class loadrestcontroller {

	@Autowired
	RestTemplate rt;
	
	@GetMapping("/getDoctors")
	public String getDoctors()
	{
		return rt.getForObject("http://doctor-service/alldoctors", String.class); 
	}
	
}
