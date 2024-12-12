package com.dev.generic_identifier;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

import com.dev.generic_identifier.entity.Employee;
import com.dev.generic_identifier.repository.EmployeeRepo;

@SpringBootApplication
public class Application {

	public static void main(String[] args) {
		ConfigurableApplicationContext context=SpringApplication.run(Application.class, args);
	
		EmployeeRepo repo=context.getBean(EmployeeRepo.class);
		
		Employee e1=new Employee();
		e1.setEmpName("Indradeo kumar");
		e1.setSalary(60000.00);
	}

}
