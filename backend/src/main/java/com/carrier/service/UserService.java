package com.carrier.service;


import java.util.List;

import com.carrier.entities.UserModel;

public interface UserService {
	public UserModel registerUser(UserModel user);
	
	public List<UserModel> getAllUser();
	
	public UserModel getUserById(long id);
	
	public String deleteUserById(long id);
	
	public UserModel updateUserById(UserModel user, Long id);

}
