package com.dlsys.sifood.ums.dto;

import java.util.ArrayList;
import java.util.List;


public class GenericResponse {
	
	private String statusCode;
	private String statusResponse;
	private List<String> description;
	
	public GenericResponse(String statusCode, String statusResponse, List<String> description) {
		this.statusCode = statusCode;
		this.statusResponse = statusResponse;
		this.description = description;
	}

	public String getStatusCode() {
		return statusCode;
	}

	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}

	public String getStatusResponse() {
		return statusResponse;
	}

	public void setStatusResponse(String statusResponse) {
		this.statusResponse = statusResponse;
	}

	public List<String> getDescription() {
		return description;
	}

	public void setDescription(List<String> description) {
		this.description = description;
	}
	
	public static List<String> toList(String message) {
		
		List<String> response = new ArrayList<String>();
		response.add(message);
		
		return response;
	}

}
