package com.dev.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

//	private Logger logger = LoggerFactory.getLogger(HomeController.class);

	@GetMapping("/user")
	public String getMessage(Model model) {
		String s = null;
		s.length();
		model.addAttribute("msg", "This is User page");
		return "index";
	}

//	@ExceptionHandler(value = ArithmeticException.class)
//	public String handleAE(ArithmeticException ae) {
//		String msg = ae.getMessage();
//		logger.error(msg);
//		return "errorPage";
//	}

}
