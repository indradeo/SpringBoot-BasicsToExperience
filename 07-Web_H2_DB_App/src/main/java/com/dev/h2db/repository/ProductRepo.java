package com.dev.h2db.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.h2db.entity.Product;

public interface ProductRepo extends JpaRepository<Product, Integer>{

}
