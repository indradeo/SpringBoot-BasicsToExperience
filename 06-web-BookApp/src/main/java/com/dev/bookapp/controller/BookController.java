package com.dev.bookapp.controller;

import java.util.Arrays;
import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

import com.dev.bookapp.entity.Book;
import com.dev.bookapp.repository.BookRepo;
import com.dev.bookapp.util.BookBinding;


@Controller
public class BookController {
	
	@Autowired
	BookRepo repo;
	
	private void init(Model model) {
		
		List<String> courses=Arrays.asList("Java", "Spring framework" , "Spring Boot", "AWS"); 
 		model.addAttribute("bookBinding", new BookBinding());
 		model.addAttribute("courses", courses);
 		model.addAttribute("book", new Book());
	}
	
	@GetMapping("/")
	public String loadIndexPage(Model model) {
		init(model);
		return "index";
	}
	
	@GetMapping("/book")
	public ModelAndView getBookById(@RequestParam("id") Integer id, Model model) {
		
		ModelAndView mav= new ModelAndView();
		Optional<Book> book=repo.findById(id);
		if(book.isPresent()) {
			mav.addObject("book", book.get());
		}
		mav.setViewName("index");
		init(model);
		return mav;
	}
	
	@PostMapping("/update")
	public String updateBook(Book b,Model model) {
		repo.save(b);
		init(model);
		return "index";
	}

}
