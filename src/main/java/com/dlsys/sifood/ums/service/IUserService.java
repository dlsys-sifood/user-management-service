package com.dlsys.sifood.ums.service;

import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.dlsys.sifood.ums.entity.Users;

public interface IUserService {
	
	public ResponseEntity<?> postUser (Users user, BindingResult request);
	
	public ResponseEntity<?> updateInfoUser(Users user, BindingResult request);
	
}
