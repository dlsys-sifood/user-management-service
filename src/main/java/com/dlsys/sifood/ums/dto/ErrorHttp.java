package com.dlsys.sifood.ums.dto;

import java.util.List;

import org.springframework.http.HttpStatus;

public class ErrorHttp {
	
	private String statusCode;
	private String statusResponse;
	private List<String> description; 
	private HttpStatus status;
	
	public ErrorHttp(String statusCode, String statusResponse, List<String> description, HttpStatus status) {
		this.statusCode = statusCode;
		this.statusResponse = statusResponse;
		this.description = description;
		this.status = status;
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

	public HttpStatus getStatus() {
		return status;
	}

	public void setStatus(HttpStatus status) {
		this.status = status;
	}

}
