package com.dev.bookapp;

import java.util.Arrays;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.dev.bookapp.entity.Book;
import com.dev.bookapp.repository.BookRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext ctxt=SpringApplication.run(Application.class, args);
	
//		BookRepo repo= ctxt.getBean(BookRepo.class);
//		
//		Book b1=new Book();
//		b1.setName("Spring");
//		b1.setPrice(2000.00);
//		
//		Book b2=new Book();
//		b2.setName("Java");
//		b2.setPrice(1600.00);
//		
//		repo.saveAll(Arrays.asList(b1,b2));
		
		
		
	}

}
