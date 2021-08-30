package com.dlsys.sifood.ums.response;

import java.util.HashMap;
import java.util.Map;

import org.springframework.stereotype.Component;
import com.dlsys.sifood.ums.dto.GenericResponse;
import com.dlsys.sifood.ums.dto.UserResponse;

@Component
public class ListResponse {

	public static Map<String, Object> responseRequest(GenericResponse err) {
		Map<String, Object> response = new HashMap<>();	
		response.put("response", err);
		return response; 
	}
	
	public static Map<String, Object> userSuccesfulResponse(UserResponse user) {
		Map<String, Object> response = new HashMap<>();	
		response.put("response", user);
		return response; 
	}
}
