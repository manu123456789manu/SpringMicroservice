package com.gl.doctorportal.security;

import org.springframework.context.annotation.Configuration;
import org.springframework.security.config.annotation.web.builders.HttpSecurity;
import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;

@Configuration
public class security extends WebSecurityConfigurerAdapter{

	@Override
	protected void configure(HttpSecurity http) throws Exception
	{
		http.authorizeRequests().
		antMatchers("/actuator/**").
		authenticated().
		anyRequest().
		permitAll();
	}
}
