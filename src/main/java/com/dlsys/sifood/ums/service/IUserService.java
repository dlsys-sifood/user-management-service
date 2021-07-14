package com.dlsys.sifood.ums.service;

import org.springframework.http.ResponseEntity;

import com.dlsys.sifood.ums.entity.Users;

public interface IUserService {
	
	public ResponseEntity<?> postUser (Users user);
	
}
