package com.dlsys.sifood.ums.controller;

import java.util.HashMap;
import java.util.Map;
import java.util.stream.Collectors;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.dlsys.sifood.ums.dto.ErrorHttp;
import com.dlsys.sifood.ums.entity.Users;
import com.dlsys.sifood.ums.service.ErrorService;
import com.dlsys.sifood.ums.service.IUserService;

@RestController
@RequestMapping(value = "/user")
public class UserController {
	
	@Autowired
	IUserService userService;
	
	@Autowired
	ErrorService errorService;
	
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> getUser(@Valid @RequestBody Users user, BindingResult request){
		
		if(request.hasErrors()) {
			return errorService.errorRequest(new ErrorHttp("400", "Bad Request", request.getFieldErrors().stream()
					.map(error -> "el campo: " + error.getField() + " " + error.getDefaultMessage())
					.collect(Collectors.toList()), HttpStatus.BAD_REQUEST));
		}
		
		return userService.postUser(user);
	}

	@RequestMapping(value = "/updateInformationUser", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@RequestBody Users user){
		Map<String, Object> response = new HashMap<>();	
		response.put("prueba", "put");
		response.put("user", user);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	

	@RequestMapping(value = "/getInformationUser", method = RequestMethod.GET)
	public ResponseEntity<?> getInformationUser(@RequestBody Users user){
		Map<String, Object> response = new HashMap<>();	
		response.put("prueba", "getFilterUser");
		response.put("user", user);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}
	
	
	@RequestMapping(value = "/getDetailUser/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getDetailUser(@PathVariable String id){
		Map<String, Object> response = new HashMap<>();	
		response.put("prueba", "getDetail");
		response.put("user", id);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
