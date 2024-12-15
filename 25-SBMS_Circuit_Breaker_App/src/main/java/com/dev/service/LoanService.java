package com.dev.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

import com.dev.binding.InterestRate;

import io.github.resilience4j.circuitbreaker.annotation.CircuitBreaker;

@Service
public class LoanService {
	
	
	private static final String SERVICE_NAME="loan-service";
	private static final String RATE_SERVICE_URL="http://localhost:8085/rate?type={type}";
	
	
	@CircuitBreaker(name = SERVICE_NAME, fallbackMethod = "getDefaultLoan")
	public InterestRate getAllLoanByTypes(String type) {
		
		RestTemplate template = new RestTemplate();
		
		ResponseEntity<InterestRate> response=template.getForEntity(RATE_SERVICE_URL, InterestRate.class, type );
		
		return response.getBody();
	}
	
	public InterestRate getDefaultLoan(Exception e) {
		System.out.println("*** FallBack Method called***");
		return new InterestRate();
	}
}
