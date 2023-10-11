package com.carrier.controller;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;

import com.carrier.entities.UserModel;
import com.carrier.service.UserServiceImpl;

@RestController
@RequestMapping("/users")
@CrossOrigin
public class UserController {
	@Autowired	
	private UserServiceImpl service;
	
	@PostMapping("/register")
	private ResponseEntity<UserModel> registerUser(@RequestBody UserModel user){
		return new ResponseEntity<>(service.registerUser(user), HttpStatus.CREATED);		
	}
	
	@GetMapping("")
	private ResponseEntity<List<UserModel>> getAllUsers(){
		return new ResponseEntity<>(service.getAllUser(), HttpStatus.OK);		
	}
	
	@GetMapping("/{id}")
	private ResponseEntity<UserModel> getUserById(@PathVariable long id){
		return new ResponseEntity<>(service.getUserById(id), HttpStatus.OK);		
	}
	
	@DeleteMapping("/{id}")
	private ResponseEntity<String> deleteUserById(@PathVariable long id){
		return new ResponseEntity<>(service.deleteUserById(id), HttpStatus.OK);		
	}
	
	@PutMapping("/{id}")
	private ResponseEntity<UserModel> updateUserById(@RequestBody UserModel user, @PathVariable long id){
		return new ResponseEntity<>(service.updateUserById(user,id), HttpStatus.OK);		
	}
}
