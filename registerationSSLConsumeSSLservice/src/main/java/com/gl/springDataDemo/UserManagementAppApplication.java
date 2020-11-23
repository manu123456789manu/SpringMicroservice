package com.gl.springDataDemo;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class UserManagementAppApplication {

	
	//commad keytool -genkey -alias local_sslcert_selfsigned -keyalg RSA -keysize 2048 -validity 700 -keypass manu123 -storepass manu123 -keystore ssl_server.jks
   // here -keypass manu123 -storepass manu123
	//here keystore password is manu123 and the truststore password is manu123
	public static void main(String[] args) {
		SpringApplication.run(UserManagementAppApplication.class, args);

	}

}
