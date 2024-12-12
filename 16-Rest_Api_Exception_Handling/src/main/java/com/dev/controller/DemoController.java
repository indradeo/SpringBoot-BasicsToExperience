package com.dev.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {

	@GetMapping("/welcome")
	public String welcome() {
		int a=10/0;
		return "Welcome To Rest API";
	}
}
