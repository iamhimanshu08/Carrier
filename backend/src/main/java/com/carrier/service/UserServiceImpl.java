package com.carrier.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import com.carrier.entities.UserModel;
import com.carrier.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService , UserDetailsService{

	@Autowired
	private UserRepository repo;
	
	public UserModel registerUser(UserModel user) {
		return repo.save(user);
	}

	public List<UserModel> getAllUser() {
		return repo.findAll();
	}

	public UserModel getUserById(long id) {
		return repo.findById(id).get();
	}

	public String deleteUserById(long id) {
		repo.deleteById(id);
		return ("Successfully Deleted");
	}

	public UserModel updateUserById(UserModel user, Long id) {
		user.setId(id);
		return repo.save(user);
	}

	@Override
	public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
		return null;
	}

}
