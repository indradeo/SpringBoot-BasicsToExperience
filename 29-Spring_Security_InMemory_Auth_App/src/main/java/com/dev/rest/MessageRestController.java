package com.dev.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {

	@GetMapping("/contact")
	public String getContact() {
		
		return "Contatct :: +91 9523134353 ";
	}
	
	@GetMapping("/greet")
	public String greet() {
		return "Hello, Good Eve";
	}

	@GetMapping("/welcome")
	public String welcome() {
		return "Welcom to my app";
	}
}
