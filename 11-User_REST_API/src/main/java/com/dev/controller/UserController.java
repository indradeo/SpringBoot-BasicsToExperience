package com.dev.controller;

import java.util.HashMap;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.entity.User;

@RestController
public class UserController {
	
	@GetMapping("/welcome")
	public ResponseEntity<String> welcome() {
		String msg="Welcome to Rest APP";
		return new ResponseEntity<String>(msg,HttpStatus.OK );
	}
	
	private Map<Integer, User> mapData= new HashMap<>();
	
	@PostMapping("/user")
	public ResponseEntity<String> saveUser(@RequestBody User user) {
		mapData.put(user.getId(), user);
		
		return new ResponseEntity<String>("User Saved" , HttpStatus.CREATED);
	}
	
	@GetMapping("/findById")
	public User getUser(@RequestParam("id")Integer id) {
		
		User user=mapData.get(id);
		System.out.println(user);
		return user;	
	}
	
	@GetMapping("/user/{id}/data")
	public User getById(@PathVariable("id")Integer id) {
		
		User user=mapData.get(id);
		System.out.println(user);
		return user;	
	}
}
