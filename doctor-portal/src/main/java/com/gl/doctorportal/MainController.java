package com.gl.doctorportal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class MainController {
	
	
	@Autowired
	RestTemplateBuilder resttemplatebuilder;
	
	@Autowired
	EurekaClient client;
	
	@GetMapping("/doctors")
	public String getDoctors()
	{
		RestTemplate rest = resttemplatebuilder.build();
		
		InstanceInfo instanceInfo = client.getNextServerFromEureka("DIESEASE-SERVICE", false);
		
		String baseUrl = instanceInfo.getHomePageUrl();
		System.out.println("Base URl:" + baseUrl);
		
		String ret = rest.getForObject( baseUrl + "/location" , String.class);
		return ret;
	}

}
