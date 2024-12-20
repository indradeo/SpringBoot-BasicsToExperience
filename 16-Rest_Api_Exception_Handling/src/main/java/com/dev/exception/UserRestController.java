package com.dev.exception;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UserRestController {

	@GetMapping("/user/{userId}")
	public String getUserName(@PathVariable("userId") Integer userId)
	{
		
		if(userId==100) {
			return "John";
		}else if(userId==200) {
			return "Smith";
		}else {
			
			 throw new UserNotFoundException("User Not Found");
		}
			
	}
}
