package com.dlsys.sifood.ums.dao;

import java.util.Date;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.data.repository.CrudRepository;

import com.dlsys.sifood.ums.entity.Users;
import org.springframework.stereotype.Repository;


@Repository
public interface IUserDao extends CrudRepository<Users, String>, JpaSpecificationExecutor<Users> {
	public Users findById(UUID id);
	public List<Users> findByUsername(String username);
	public Users findByUsernameAndPassword(String username, String password);
}
