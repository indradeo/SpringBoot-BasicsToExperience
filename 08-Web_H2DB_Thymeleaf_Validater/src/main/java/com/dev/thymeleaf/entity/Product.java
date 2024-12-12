package com.dev.thymeleaf.entity;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.validation.constraints.NotBlank;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Positive;
import javax.validation.constraints.Size;

import lombok.Data;

@Entity
@Data
public class Product {
	
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private Integer pid;
	
	@NotBlank(message = "name is mandatory")
	@Size(min = 3, max = 15, message = "Name should have 3 to 15 characters")
	private String name;
	
	@NotNull(message = "price is mandatory")
	@Positive(message = "price should be positive number")
	private Double price;
	
	@NotNull(message = "quantity is mandatory")
	@Positive(message = "qty should be positive number")
	private Integer qty;
	
}
