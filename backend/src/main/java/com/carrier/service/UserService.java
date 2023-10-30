package com.carrier.service;


import java.util.List;

import javax.servlet.http.HttpServletResponse;

import com.carrier.entities.UserModel;

public interface UserService {
	public UserModel registerUser(UserModel user,HttpServletResponse response);
	
	public List<UserModel> getAllUser();
	
	public UserModel getUserById(long id);
	
	public String deleteUserById(long id);
	
	public UserModel updateUserById(UserModel user, Long id);

}
