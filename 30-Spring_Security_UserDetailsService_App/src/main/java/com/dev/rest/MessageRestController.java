package com.dev.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MessageRestController {
	
	@GetMapping("/public-user")
	public String publicUser() {
		return "every can access this ";
	}
	
	@GetMapping("/admin-user")
	public String adminUser() {
		return "U R admin User";
	}
	
	@GetMapping("/normal-user")
	public String normUser() {
		return "U R Normal User";
	}
}
