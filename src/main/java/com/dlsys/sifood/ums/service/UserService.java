package com.dlsys.sifood.ums.service;

import java.util.HashMap;
import java.util.Map;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.dlsys.sifood.ums.dao.IUserDao;
import com.dlsys.sifood.ums.entity.Users;

@Service
public class UserService implements IUserService {

	@Autowired
	IUserDao userDao;
	
	@Override
	@Transactional
	public ResponseEntity<?> postUser(Users user) {
		
		Map<String, Object> response = new HashMap<>();
		Users result = null;
		user.setFlag(1);
		user.getUserDetail().setFlag(1);

		try {
			//dao
			result = userDao.save(user);
		} catch (Exception e) {
			response.put("hola", e.getMessage());
			return new ResponseEntity<Map<String, Object>>(response, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	
		response.put("result", result);
		return new ResponseEntity<Map<String, Object>>(response, HttpStatus.OK);
	}

}
