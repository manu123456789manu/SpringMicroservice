package com.loadbalancerserver.loadbalancerserver;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.web.client.RestTemplate;

@SpringBootApplication
@RibbonClient(name = "doctor-service")
public class LoadbalancerserverApplication {

	public static void main(String[] args) {
		SpringApplication.run(LoadbalancerserverApplication.class, args);
	}
	
	@Bean
	@LoadBalanced
	RestTemplate getRestTemplate()
	{
		return new RestTemplate();
		
	}

}
