package com.dev.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dev.feign.GreetFeignClient;

@RestController
public class WelcomeRestController {
	@Autowired
	private GreetFeignClient greetFeignClient;

	@GetMapping("/welcome")
	public String welcome() {
		String resp = greetFeignClient.invokeGreetApi();
		return resp+", Welcome To Dev development";
	}
}
