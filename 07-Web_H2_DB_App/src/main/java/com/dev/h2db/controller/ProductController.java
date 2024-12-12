package com.dev.h2db.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.dev.h2db.entity.Product;
import com.dev.h2db.repository.ProductRepo;

@Controller
public class ProductController {
	
	@Autowired
	private ProductRepo repo;
	
	@GetMapping("/")
	public String LoadIndexPage(Model model ) {
		model.addAttribute("product", new Product());
		return "index";
	}
	
	@GetMapping("/viewProducts")
	public String getProducts(Model model) {
		model.addAttribute("products",repo.findAll());
		return "products";
	}
	
	@PostMapping("/save")
	public String saveProduct(@ModelAttribute Product product, Model model) {
		product= repo.save(product);
		if(product.getPid()!=null) {
			model.addAttribute("save", "Data Saved !!");
		}
		return "index";
	}
}
