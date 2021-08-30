package com.dlsys.sifood.ums.controller;

import javax.validation.Valid;

import com.dlsys.sifood.ums.model.UserAuth;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;

import com.dlsys.sifood.ums.entity.Users;
import com.dlsys.sifood.ums.model.UserModelFilter;
import com.dlsys.sifood.ums.service.IUserService;

import springfox.documentation.swagger2.annotations.EnableSwagger2;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;


@RestController
@EnableSwagger2
@RequestMapping(value = "/user")
public class UserController {

	private final Logger logger = LoggerFactory.getLogger(UserController.class);

	@Autowired
	private IUserService userService;

	
	/**
	 * this method is for create a new user, if the username exists return a 400 BAD REQUEST 
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/", method = RequestMethod.POST)
	public ResponseEntity<?> getUser(@Valid @RequestBody Users user, BindingResult request) {
		return userService.postUser(user, request);
	}

	/**
	 * this method is for update a exist user
	 * @param user
	 * @param request
	 * @return
	 */
	@RequestMapping(value = "/updateInformationUser", method = RequestMethod.PUT)
	public ResponseEntity<?> updateUser(@Valid @RequestBody Users user, BindingResult request) {
		return userService.updateInfoUser(user, request);
	}

	/**
	 * this method is for return all the users that are existent in the data base
	 * @param filter
	 *
	 * @return
	 */
	@RequestMapping(value = "/getInformationUser", method = RequestMethod.GET)
	public ResponseEntity<?> getInformationUser(@RequestBody UserModelFilter filter) {
		return userService.getInformationUser(filter);
	}

	@RequestMapping(value = "/getAutentcationUser/username/{username}/password/{password}", method = RequestMethod.GET)
	public ResponseEntity<?> getAuthenticationUser(@PathVariable String username, @PathVariable String password) {
		UserAuth userAuth = new UserAuth();
		userAuth.setUsername(username);
		userAuth.setPassword(password);
		return userService.getAuthenticationUser(userAuth);
	}


}
