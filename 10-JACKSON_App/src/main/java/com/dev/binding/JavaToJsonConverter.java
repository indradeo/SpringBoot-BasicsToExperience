package com.dev.binding;

import java.io.File;

import com.fasterxml.jackson.databind.ObjectMapper;

public class JavaToJsonConverter {
	
	public static void main(String[] args) throws Exception {
		
		Address a = new Address();
		a.setPincode(825312);
		a.setCity("Bishnugarh");
		a.setDistrict("Hazaribag");
		a.setState("Jharkhand");
		
		Customer c = new Customer();
		c.setId(101);
		c.setName("Dev");
		c.setEmail("abcd@gmail.com");
		c.setPhno(9876543210l);
		c.setAddress(a);
		
		ObjectMapper mapper = new ObjectMapper();
		mapper.writeValue(new File("customer.json"), c);
		System.out.println("json file created");
		
	}
}
