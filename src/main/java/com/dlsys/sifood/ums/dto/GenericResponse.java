package com.dlsys.sifood.ums.dto;

import java.util.ArrayList;
import java.util.List;

import lombok.Data;

@Data
public class GenericResponse {
	
	private String statusCode;
	private String statusResponse;
	private List<String> description;
	
	public GenericResponse(String statusCode, String statusResponse, List<String> description) {
		this.statusCode = statusCode;
		this.statusResponse = statusResponse;
		this.description = description;
	}

	
	/**
	 * this method return a list of a message for a response
	 * @param message
	 * @return
	 */
	public static List<String> toList(String message) {
		
		List<String> response = new ArrayList<String>();
		response.add(message);
		
		return response;
	}

}
