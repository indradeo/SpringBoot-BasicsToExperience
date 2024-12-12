package com.dev.thymeleaf.controller;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.dev.thymeleaf.entity.Product;
import com.dev.thymeleaf.repository.ProductRepo;

@Controller
public class ProductController {

	@Autowired
	private ProductRepo repo;

	@GetMapping("/")
	public String home(Model model) {
		model.addAttribute("product", new Product());
		return "index";
	}

	@PostMapping("/save")
	public String saveProduct(@Validated @ModelAttribute Product product, BindingResult result, Model model) {

		if (result.hasErrors()) {
			return "index";
		}
		Integer check=product.getPid();
		Product p = repo.save(product);

		if (p.getPid() != null && check==null) {
			model.addAttribute("save", "product saved !! ");
		}
		else if(p.getPid()!=null && check!=null){
			model.addAttribute("save", "product edited !! ");
		}
		model.addAttribute(new Product());
		return "index";
	}

	@GetMapping("/products")
	public String getData(Model model) {
		model.addAttribute("products", repo.findAll());
		return "data";
	}

	@GetMapping("/delete/{id}")
	public String deleteData(@PathVariable("id") Integer id, Model model) {
		repo.deleteById(id);
		model.addAttribute("delete", "Product deleted");
		model.addAttribute("products", repo.findAll());
		return "data";
	}

	@GetMapping("/edit/{id}")
	public String editData(@PathVariable("id") Integer id, Model model) {

		Optional<Product> p = repo.findById(id);
		if(p.isPresent()) {
			model.addAttribute("product", p.get());
			model.addAttribute("delete", "Product Edited");
			return "index";
		}
	
		model.addAttribute("product", new Product());
		return "index";
	}

	@GetMapping("/deleteAll")
	public String deleteAll(Model model) {

		repo.deleteAll();
		model.addAttribute("delete", "All Records Deleted");
		model.addAttribute("products", repo.findAll());

		return "data";
	}

}
