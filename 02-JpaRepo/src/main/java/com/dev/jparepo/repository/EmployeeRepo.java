package com.dev.jparepo.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.jparepo.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
