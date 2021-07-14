package com.dlsys.sifood.ums.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import com.dlsys.sifood.ums.dto.ErrorHttp;

@Service
public class ErrorService {

	public ResponseEntity<?> errorRequest(ErrorHttp err) {
		Map<String, Object> response = new HashMap<>();	
		
		response.put("statusCode", err.getStatusCode());
		response.put("statusResponse", err.getStatusResponse());
		

		response.put("description", err.getDescription());
		
		return new ResponseEntity<Map<String, Object>>(response, err.getStatus()); 
		
	}
	
}
