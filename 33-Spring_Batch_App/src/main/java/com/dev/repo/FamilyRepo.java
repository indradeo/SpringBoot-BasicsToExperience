package com.dev.repo;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.entity.Family;

public interface FamilyRepo extends JpaRepository<Family,Integer> {

}
