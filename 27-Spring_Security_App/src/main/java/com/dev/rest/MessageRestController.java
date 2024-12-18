package com.dev.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {
	
	@GetMapping("/hi")
	public String getMessage() {
		return "Hi, Welcome To Spring Security";
	}
	
	@GetMapping("/hello")
	public String getHelloMessage() {
		return "Hello Wolrd !!";
	}
	
	@GetMapping("/contact")
	public String getContact() {
		return "Contact :: +91 7829396870";
	}
}
