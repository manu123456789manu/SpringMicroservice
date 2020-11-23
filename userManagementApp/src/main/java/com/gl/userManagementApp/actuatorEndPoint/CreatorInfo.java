package com.gl.userManagementApp.actuatorEndPoint;

import java.util.HashMap;
import java.util.LinkedHashMap;

import com.fasterxml.jackson.annotation.JsonInclude;

@JsonInclude(JsonInclude.Include.NON_NULL)
public class CreatorInfo {
	
	private HashMap creatorInfo = new LinkedHashMap<String,Object>();

	public HashMap getCreatorInfo() {
		return creatorInfo;
	}

	public void setCreatorInfo(HashMap creatorInfo) {
		this.creatorInfo = creatorInfo;
	}

}
