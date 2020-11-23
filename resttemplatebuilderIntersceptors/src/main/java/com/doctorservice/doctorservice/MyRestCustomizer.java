package com.doctorservice.doctorservice;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.web.client.RestTemplateCustomizer;
import org.springframework.context.annotation.Primary;
import org.springframework.web.client.RestTemplate;


public class MyRestCustomizer implements RestTemplateCustomizer {

	
	@Autowired
	MyRequestIntersceptor myRequestIntersceptor;
	
	@Override
	public void customize(RestTemplate restTemplate) {
		
		
		restTemplate.getInterceptors().add(myRequestIntersceptor);
	}

}
