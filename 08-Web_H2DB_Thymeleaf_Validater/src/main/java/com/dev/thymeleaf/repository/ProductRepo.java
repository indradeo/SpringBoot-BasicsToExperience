package com.dev.thymeleaf.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.dev.thymeleaf.entity.Product;

@Repository
public interface ProductRepo extends JpaRepository<Product, Integer> {

}
