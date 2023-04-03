package com.userservice.com.service;

import java.util.List;

import com.userservice.com.enities.User;

public interface UserService {
	
	//create
	User savUser(User user);
	//get all user
	List<User> getAlluser();

	//get single user user
	User getUser(String userId);

}
