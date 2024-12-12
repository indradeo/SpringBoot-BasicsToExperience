package com.dev.springwebapp.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MessageController {
	
	@GetMapping("/welcome")
	public ModelAndView getWelcomeMsg() {
		
		ModelAndView andView = new ModelAndView();
		
		andView.addObject("msg","Welcome to web App");
		andView.setViewName("message");
		
		return andView;
	}

}
