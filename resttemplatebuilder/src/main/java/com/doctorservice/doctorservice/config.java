package com.doctorservice.doctorservice;

import java.time.Duration;

import org.springframework.boot.web.client.RestTemplateBuilder;
import org.springframework.boot.web.client.RootUriTemplateHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.util.UriTemplateHandler;

@Configuration
public class config {
	
	@Bean
	public RestTemplate getrestBuilder(RestTemplateBuilder builder)
	{
		UriTemplateHandler uri = new RootUriTemplateHandler("http://localhost:8082");
		
		RestTemplate rs = builder.uriTemplateHandler(uri).setReadTimeout(Duration.ofSeconds(5)).build();
		
		//normal resttemplate
		//RestTemplate rs = builder.build();
		return rs;
	}

}
