package com.dlsys.sifood.ums.controller;

import java.util.HashMap;
import java.util.Map;

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

import com.dlsys.sifood.ums.entity.Users;
import com.dlsys.sifood.ums.service.IUserService;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

@RestController
@RequestMapping(value = "/user")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(this.getClass());

	@Autowired
	IUserService userService;

	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> getUser(@Valid @RequestBody Users user, BindingResult request) {
		logger.debug("Sample debug message");
		logger.info("Sample info message");
		logger.warn("Sample warn message");
		logger.error("Sample error message");
		return userService.postUser(user, request);
	}

	@RequestMapping(value = "/updateInformationUser", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@Valid @RequestBody Users user, BindingResult request) {
		return userService.updateInfoUser(user, request);
	}

	@RequestMapping(value = "/getInformationUser", method = RequestMethod.GET)
	public ResponseEntity<?> getInformationUser(@RequestBody Users user) {
		Map<String, Object> response = new HashMap<>();
		response.put("prueba", "getFilterUser");
		response.put("user", user);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

	@RequestMapping(value = "/getDetailUser/{id}", method = RequestMethod.GET)
	public ResponseEntity<?> getDetailUser(@PathVariable String id) {
		Map<String, Object> response = new HashMap<>();
		response.put("prueba", "getDetail");
		response.put("user", id);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
