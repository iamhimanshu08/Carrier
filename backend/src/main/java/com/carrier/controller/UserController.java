package com.carrier.controller;



import java.util.List;

import javax.servlet.http.HttpServletResponse;

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
	private ResponseEntity<UserModel> registerUser(@RequestBody UserModel user, HttpServletResponse response){
		
//		UserDetails userDetails = new User(user.getEmail(), password, new ArrayList<>());
//		String token = util.generateToken(userDetails);
//		Map<String, String> map = new HashMap<>();
//		map.put("token", token);
//		try {
//			new ObjectMapper().writeValue(response.getOutputStream(), map);
//		} catch (StreamWriteException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (DatabindException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		} catch (IOException e) {
//			// TODO Auto-generated catch block
//			e.printStackTrace();
//		}
//		 
		return new ResponseEntity<>(service.registerUser(user, response), HttpStatus.CREATED);		
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
