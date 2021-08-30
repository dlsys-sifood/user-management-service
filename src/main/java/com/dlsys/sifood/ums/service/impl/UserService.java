package com.dlsys.sifood.ums.service.impl;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.UUID;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import javax.transaction.Transactional;

import com.dlsys.sifood.ums.model.UserAuth;
import com.dlsys.sifood.ums.response.EntityResponse;
import com.dlsys.sifood.ums.service.IUserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.validation.BindingResult;

import com.dlsys.sifood.ums.dao.IUserDao;
import com.dlsys.sifood.ums.entity.Users;
import com.dlsys.sifood.ums.model.UserModelFilter;

@Service
public class UserService implements IUserService {

	@Autowired
	private IUserDao userDao;

	@Override
	@Transactional
	public ResponseEntity<?> postUser(Users user, BindingResult request) {
		if (request.hasErrors()) {
			return EntityResponse.getErrorsFieldResponse(request);
		}
		try {
			List<Users> userExist = userDao.findByUsername(user.getUsername());
			if (userExist.isEmpty()) {
				userDao.save(user);
			} else {
				return EntityResponse.getErrorCustomMessage("el usuario ya se encuentra registrado");
			}
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		}
		return EntityResponse.getSuccessfullUser(user);
	}

	@Override
	@Transactional
	public ResponseEntity<?> updateInfoUser(Users user, BindingResult request) {
		if (request.hasErrors()) {
			return EntityResponse.getErrorsFieldResponse(request);
		}
		try {
			List<Users> userExist = userDao.findByUsername(user.getUsername());
			if (userExist.isEmpty()) {
				userDao.save(user);
			} else {
				return EntityResponse.getErrorCustomMessage("el usuario ya se encuentra registrado");
			}
		} catch (RuntimeException e) {
			throw new RuntimeException(e);
		}
		return EntityResponse.getSuccessfullUser(user);
	}

	@Override
	public ResponseEntity<?> getInformationUser(UserModelFilter user) {
	
		List<Users> result = new ArrayList<Users>();

		try {
			 result = userDao.findAll(new Specification<Users>() {			
				@Override
				public Predicate toPredicate(Root<Users> root, CriteriaQuery<?> cq, CriteriaBuilder cb) {
					Predicate p = cb.conjunction();
					if(!user.getFullname().isEmpty()) {
					p = cb.and(p, cb.like(root.get("name"), "%" + user.getFullname() + "%"));
					}
					if(!user.getUsername().isEmpty()) {
					p = cb.and(p, cb.like(root.get("username"), "%" + user.getUsername() + "%"));
					}
					if(!user.getId().isEmpty()) {
					p = cb.and(p, cb.equal(root.get("id"),  UUID.fromString(user.getId())));
					}
					if(!user.getIdRole().isEmpty()) {
					p = cb.and(p, cb.equal(root.get("idRole"), Integer.parseInt(user.getIdRole())));
					}
					if(!user.getIdFather().isEmpty()) {
						p = cb.and(p, cb.equal(root.get("idFather"),  UUID.fromString(user.getIdFather())));
					}
					if(!user.getDateAt().isEmpty() && !user.getDateTo().isEmpty()) {
						Date dateTo = new Date();
						Date dateAt = new Date();
						try {
							dateAt = new SimpleDateFormat("yyyy-MM-dd").parse(user.getDateAt());
							dateTo = new SimpleDateFormat("yyyy-MM-dd").parse(user.getDateTo());
						} catch (ParseException e) {
							e.printStackTrace();
						}  
						p = cb.and(p, cb.between(root.get("dateRegister"), dateAt, dateTo));
					}
					return p;
				}
			});
		}catch (RuntimeException e) {
			throw new RuntimeException(e);
		}
		
		if (result.isEmpty()) {
			return EntityResponse.getNotFoundMessage();
		}
		
		return EntityResponse.getSuccessfullListUser(result);
	}

	@Override
	public ResponseEntity<?> getAuthenticationUser(UserAuth userAuth) {
		if(userAuth.getUsername().isEmpty() || userAuth.getPassword().isEmpty()){
			return EntityResponse.getErrorCustomMessage("los datos no deben ser vacios");
		}
		Users user = new Users();
		try {
			user = userDao.findByUsernameAndPassword(userAuth.getUsername(), userAuth.getPassword());
		}catch (RuntimeException ex){
			throw new RuntimeException(ex);
		}
		if(user == null){
			return EntityResponse.getNotFoundMessage();
		}
		return EntityResponse.getSuccessfullUserAuthentication(user);
	}

}
