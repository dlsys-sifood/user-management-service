package com.dlsys.sifood.ums.dao;

import org.springframework.data.repository.CrudRepository;

import com.dlsys.sifood.ums.entity.Users;

public interface IUserDao extends CrudRepository<Users, String> {

}
