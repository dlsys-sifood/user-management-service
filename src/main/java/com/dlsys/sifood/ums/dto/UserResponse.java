package com.dlsys.sifood.ums.dto;

import java.util.List;

import com.dlsys.sifood.ums.entity.Users;

public class UserResponse extends GenericResponse{

	private Users user;
	private List<Users> users;
	
	public UserResponse(String statusCode, String statusResponse, List<String> description, Users user) {
		super(statusCode, statusResponse, description);
		this.user = user;
	}
	
	public UserResponse(String statusCode, String statusResponse, List<String> description, List<Users> users) {
		super(statusCode, statusResponse, description);
		this.users = users;
	}

	public Users getUser() {
		return user;
	}

	public void setUser(Users user) {
		this.user = user;
	}

	public List<Users> getUsers() {
		return users;
	}

	public void setUsers(List<Users> users) {
		this.users = users;
	}

	
}
