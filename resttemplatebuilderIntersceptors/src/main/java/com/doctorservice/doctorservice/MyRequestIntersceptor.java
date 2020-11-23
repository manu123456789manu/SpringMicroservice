package com.doctorservice.doctorservice;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.nio.charset.StandardCharsets;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpRequest;
import org.springframework.http.client.ClientHttpRequestExecution;
import org.springframework.http.client.ClientHttpRequestInterceptor;
import org.springframework.http.client.ClientHttpResponse;

public class MyRequestIntersceptor implements ClientHttpRequestInterceptor {

	
	Logger logger = LoggerFactory.getLogger("UserManagementApp");
	
	@Override
	public ClientHttpResponse intercept(HttpRequest request, byte[] body, ClientHttpRequestExecution execution)
			throws IOException {
		
		logger.info(" URI", request.getURI());
		logger.info("Method",request.getMethod());
		logger.info("Headers",request.getHeaders());
		
		
		System.out.println("URI" + request.getURI());
		System.out.println("Method" + request.getMethod());
		System.out.println("Headers" + request.getHeaders());
		
		ClientHttpResponse res = execution.execute(request, body);
		
		MyClientHttpResponse myClientHttpResponse = new MyClientHttpResponse(res);
		
		logger.info("Response detils 1.X");
		logger.info("status",res.getStatusCode() + "|done");
		logger.info("Body",getResponsebody(myClientHttpResponse.getBody()) + "|nobody");
		
		
		System.out.println("ssssssResponse detils 1.X");
		System.out.println("status" + res.getStatusCode() + "|done");
		System.out.println("Body" + getResponsebody(myClientHttpResponse.getBody()) + "|nobody");
			
		return myClientHttpResponse;
	}
	
	public String getResponsebody(InputStream resbody) throws IOException
	{
		
		StringBuilder inputstringbuilder = new StringBuilder();
		
		try(BufferedReader br = new BufferedReader(new InputStreamReader(resbody , StandardCharsets.UTF_8)))
		{
			String line = br.readLine();
			while(line!=null)
			{
				inputstringbuilder.append(line);
				inputstringbuilder.append('\n');
				line = br.readLine();

			}
			
			
		}
		return inputstringbuilder.toString() ;
		
	}

}
