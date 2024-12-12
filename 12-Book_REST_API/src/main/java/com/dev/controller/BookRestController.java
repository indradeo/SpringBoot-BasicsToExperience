package com.dev.controller;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.dev.binding.Book;

@RestController
public class BookRestController {
	
	
	@PostMapping(value = "/addBook", consumes = {"application/xml", "application/json"})
	public ResponseEntity<String> addBook(@RequestBody Book b) {	
		System.out.println(b);
		//logic to add Book 
		String msg= "book added";
		
		return new ResponseEntity<String>(msg,HttpStatus.CREATED);
	}
	
	@GetMapping(value = "/book", produces = {"application/xml", "application/json"})
	public Book getBook() {
		Book b = new Book();
		b.setId(301);
		b.setName("Spring Boot");
		b.setPrice(2300.0);
		
		return b;
	}
}
