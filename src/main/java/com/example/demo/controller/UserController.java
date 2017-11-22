package com.example.demo.controller;

import java.util.Map;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.model.User;
import com.example.demo.repository.UserRepository;

@RestController
@RequestMapping("/api/redis")
public class UserController {
	
	private UserRepository userRepository;

	public UserController(UserRepository userRepository) {
		super();
		this.userRepository = userRepository;
	}
	
	@GetMapping("/add/{id}/{name}")
	public User add(@PathVariable("id") String id,@PathVariable("name") String name ){
		
		userRepository.save(new User(id,name,"2000"));
		
		return userRepository.findById(id);
		
	}
	
	@GetMapping("/all")
	public Map<String, User> all(){
		
		return userRepository.findAll();
		
	}
	
	@GetMapping("/update/{id}/{name}")
	public User update(@PathVariable("id") String id,@PathVariable("name") String name ){
		
		userRepository.save(new User(id,name,"1000"));
		
		return userRepository.findById(id);
		
	}
	
	
	
	

}
