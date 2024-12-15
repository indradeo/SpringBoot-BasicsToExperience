package com.dev.service;

import org.springframework.stereotype.Service;

import com.dev.binding.InterestRate;

@Service
public class RateService {
	
	public InterestRate getRateByType(String type) {
		
		InterestRate interestRate = new InterestRate();
		type=type.toUpperCase();
		if(type.equals("PERSONAL")) {
			interestRate.setId(1);
			interestRate.setType(type);
			interestRate.setRateValue(10d);
		}else if(type.equals("HOME")) {
			interestRate.setId(2);
			interestRate.setType(type);
			interestRate.setRateValue(5d);
		}else if(type.equals("CAR")) {
			interestRate.setId(3);
			interestRate.setType(type);
			interestRate.setRateValue(6d);
		}else {
			return null;
		}
		return interestRate;
	}
}
