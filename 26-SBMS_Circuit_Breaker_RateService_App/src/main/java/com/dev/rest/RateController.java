package com.dev.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.dev.binding.InterestRate;
import com.dev.service.RateService;

@RestController
public class RateController {
	
	@Autowired
	private RateService rateService;
	
	@GetMapping("/rate")
	public InterestRate getRate(@RequestParam("type") String type) {
		
		return rateService.getRateByType(type);
	}
}
