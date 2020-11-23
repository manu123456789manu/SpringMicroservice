package com.doctorservice.doctorservice;

import java.io.ByteArrayInputStream;
import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;

import org.apache.tomcat.util.http.fileupload.IOUtils;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.client.ClientHttpResponse;

public class MyClientHttpResponse implements ClientHttpResponse{


	private ClientHttpResponse client;
	private byte[] body = null;

	MyClientHttpResponse(ClientHttpResponse res)
	{
		this.client = res;
	}

	@Override
	public InputStream getBody() throws IOException {
		
		if(body!=null)
		{
			return new ByteArrayInputStream(body);
		}
		
		ByteArrayOutputStream outputStream = new 
				ByteArrayOutputStream();
		IOUtils.copyLarge(client.getBody(), outputStream);
		body = outputStream.toByteArray();
		return new ByteArrayInputStream(body);
	}

	@Override
	public HttpHeaders getHeaders() {
		// TODO Auto-generated method stub
		return client.getHeaders();
		}

	@Override
	public HttpStatus getStatusCode() throws IOException {
		// TODO Auto-generated method stub
		return client.getStatusCode();
	}

	@Override
	public int getRawStatusCode() throws IOException {
		// TODO Auto-generated method stub
		return client.getRawStatusCode();
	}

	@Override
	public String getStatusText() throws IOException {
		// TODO Auto-generated method stub
		return client.getStatusText();
	}

	@Override
	public void close() {
		client.close();		
	}

}
