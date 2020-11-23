package com.openfeign.openfiegn;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;

@SpringBootApplication
@EnableFeignClients
public class OpenfiegnApplication 
{

	public static void main(String[] args) {
		SpringApplication.run(OpenfiegnApplication.class, args);
	}

}
