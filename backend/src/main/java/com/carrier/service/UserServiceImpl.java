package com.carrier.service;

import java.util.ArrayList;
import java.util.List;

import javax.servlet.http.HttpServletResponse;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.carrier.entities.UserModel;
import com.carrier.repository.UserRepository;

@Service
public class UserServiceImpl implements UserService , UserDetailsService{

	@Autowired
	private UserRepository repo;
	
	@Autowired
	private PasswordEncoder encoder;
	
	
	public UserModel registerUser(UserModel user,HttpServletResponse response) {
		user.setPassword(encoder.encode(user.getPassword()));
		return repo.save(user);
	}

	public List<UserModel> getAllUser() {
		System.out.println("Get method");
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
		UserModel user = repo.findByEmail(username);
				
		if (user != null) {
			return new User(user.getEmail(), user.getPassword(),
					new ArrayList<>());
		} else {
			throw new UsernameNotFoundException("User not found with username: " + username);
		}
	}
	
	
	

}
