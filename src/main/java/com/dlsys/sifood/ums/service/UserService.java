package com.dlsys.sifood.ums.service;

import java.util.Map;
import java.util.stream.Collectors;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.dlsys.sifood.ums.dao.IUserDao;
import com.dlsys.sifood.ums.dto.GenericResponse;
import com.dlsys.sifood.ums.dto.UserResponse;
import com.dlsys.sifood.ums.entity.Users;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserDao userDao;

	@Override
	@Transactional
	public ResponseEntity<?> postUser(Users user, BindingResult request) {
		if (request.hasErrors()) {
			return new ResponseEntity<Map<String, Object>>(
					ResponseService.responseRequest(new GenericResponse("400", "Bad Request",
							request.getAllErrors().stream()
									.map(e -> "el campo: " + e.getObjectName() + " " + e.getDefaultMessage())
									.collect(Collectors.toList()))),
					HttpStatus.BAD_REQUEST);
		}

		try {
			userDao.save(user);
		} catch (RuntimeException e) {
			return new ResponseEntity<Map<String, Object>>(ResponseService.responseRequest(new GenericResponse("500",
					"Internal Server Error", GenericResponse.toList("error en el servidor"))), HttpStatus.OK);

		}

		return new ResponseEntity<Map<String, Object>>(ResponseService.userSuccesfulResponse(
				new UserResponse("200", "OK", GenericResponse.toList("el usuario se a creado correctamente"), user)),
				HttpStatus.OK);
	}

	@Override
	public ResponseEntity<?> updateInfoUser(Users user, BindingResult request) {
		return null;

	}

}
