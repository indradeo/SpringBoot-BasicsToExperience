package com.dev.bookapp.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.bookapp.entity.Book;

public interface BookRepo extends JpaRepository<Book,Integer> {

}
