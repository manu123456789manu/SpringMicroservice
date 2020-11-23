package com.gl.userManagementApp.actuatorEndPoint;

import java.util.HashMap;
import java.util.LinkedHashMap;

import org.springframework.boot.actuate.endpoint.annotation.Endpoint;
import org.springframework.boot.actuate.endpoint.annotation.ReadOperation;
import org.springframework.boot.actuate.endpoint.annotation.Selector;
import org.springframework.boot.actuate.endpoint.annotation.WriteOperation;
import org.springframework.boot.actuate.endpoint.annotation.DeleteOperation;;


@Endpoint(id = "creator")
public class CreatorEndpoint {

 @ReadOperation
 public CreatorInfo getCreatorInfo()
 {
	 CreatorInfo myInfo = new CreatorInfo();
	 HashMap hp = new LinkedHashMap<String,Object>();
	 hp.put("Name", "manu");
	 hp.put("Author", "I dont know");
	 return myInfo;
 }
 
 @ReadOperation
 public String userAppEndPointByName(@Selector String id)
 {
	 return "Your custom value:" + id;
 }
 
 @WriteOperation
 public void writeOperation(@Selector String id)
 {
	 
 }
 
 @DeleteOperation 
 public void DeleteOperation(@Selector String id)
 {
	 
 }
 
}
