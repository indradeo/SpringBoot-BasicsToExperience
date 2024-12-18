package com.dev.rest;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

	@GetMapping("/admin")
	public String admin() {
		
		return "Welcome , Admin saale";
	}
	
	@GetMapping("/user")
	public String user() {
		return "Welcome , User bhadve" ;
	}
	
	@GetMapping("/welcome")
	public String welcome() {
		return "Welcome, nalle public";
	}
}
