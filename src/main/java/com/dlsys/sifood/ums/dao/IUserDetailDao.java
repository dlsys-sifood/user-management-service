package com.dlsys.sifood.ums.dao;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.dlsys.sifood.ums.entity.UserDetail;

@Repository
public interface IUserDetailDao extends CrudRepository<UserDetail, String> {
	
}
