package com.dev.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.binding.InterestRate;
import com.dev.service.LoanService;

@RestController
public class LoanController {
	

	@Autowired
	private LoanService loanService;
	
	@GetMapping("/loans")
	public InterestRate getLoans(@RequestParam("type") String type) {
		
		return loanService.getAllLoanByTypes(type);
	}

}
