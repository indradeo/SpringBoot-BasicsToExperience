package com.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	
//	private Logger logger= LoggerFactory.getLogger(HomeController.class);
	
	@GetMapping("/")
	public String getMessage(Model model) {
		int i=1/0;
		model.addAttribute("msg", "Welcome to My web page");
		return "index";
	}
	
	@GetMapping("/greet")
	public String greet(Model model) {
		
		model.addAttribute("msg", "Hello Buddy");
		
		String s=null;
		s.length();
		return "index";
	}
	
	
//	@ExceptionHandler(value = ArithmeticException.class)
//	public String handleAE(ArithmeticException ae) {
//		String msg=ae.getMessage();
//		logger.error(msg);
//		return "errorPage";
//	}
//	
//	@ExceptionHandler(value = Exception.class)
//	public String handleAllEx(Exception e) {
//		logger.error(e.getMessage());
//		return "errorPage";
//	}
}
