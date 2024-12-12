package com.dev.generic_identifier.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dev.generic_identifier.entity.Employee;

public interface EmployeeRepo extends JpaRepository<Employee, Integer> {

}
