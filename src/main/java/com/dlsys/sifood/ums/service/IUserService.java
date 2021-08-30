package com.dlsys.sifood.ums.service;

import com.dlsys.sifood.ums.model.UserAuth;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.BindingResult;

import com.dlsys.sifood.ums.entity.Users;
import com.dlsys.sifood.ums.model.UserFilter;
import com.dlsys.sifood.ums.model.UserModelFilter;

public interface IUserService {
	
	public ResponseEntity<?> postUser (Users user, BindingResult request);
	
	public ResponseEntity<?> updateInfoUser(Users user, BindingResult request);
	
	public ResponseEntity<?> getInformationUser(UserModelFilter user);

	public ResponseEntity<?> getAuthenticationUser(UserAuth userAuth);
	
}
