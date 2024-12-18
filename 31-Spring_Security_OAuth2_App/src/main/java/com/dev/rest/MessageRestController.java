package com.dev.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {
	
	@GetMapping("/")
	public String sayHi() {
		return "Hi...";
	}
	
	@GetMapping("/home")
	public String home() {
		return "Welcome to Home ";
	}
}
