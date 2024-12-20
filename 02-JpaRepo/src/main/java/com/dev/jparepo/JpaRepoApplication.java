package com.dev.jparepo;

import java.awt.print.Pageable;
import java.util.Arrays;
import java.util.List;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Sort;

import com.dev.jparepo.entity.Employee;
import com.dev.jparepo.repository.EmployeeRepo;

@SpringBootApplication
public class JpaRepoApplication {

	public static void main(String[] args) {
		ConfigurableApplicationContext context = SpringApplication.run(JpaRepoApplication.class, args);

		EmployeeRepo empRepo = context.getBean(EmployeeRepo.class);

//		Employee e1=new Employee();
//		Employee e2=new Employee();
//		Employee e3=new Employee();
//		Employee e4=new Employee();
//		
//		e1.setEmpId(101);
//		e1.setEmpName("Indradeo");
//		e1.setDesig("Java Developer");
//		
//		e2.setEmpId(102);
//		e2.setEmpName("Himanshu");
//		e2.setDesig("Dot Net Developer");
//		
//		e3.setEmpId(103);
//		e3.setEmpName("Ayus");
//		e3.setDesig("Technical Support");
//	
//		e4.setEmpId(104);
//		e4.setEmpName("Chandan");
//		e4.setDesig("DevOps Engineer");
//		empRepo.saveAll(Arrays.asList(e1,e2,e3,e4));

		//Sorting...
		Sort sortAscending = Sort.by("empName").ascending();
		Sort sortDescending = Sort.by("empName").descending();
		List<Employee> list = empRepo.findAll(sortAscending);
		System.out.println(list);
		
		//Pagination
		int pageNo = 1;
		int pageSize = 2;
		// pageNo:- 0->1
		// pageSize is number of records in a page
		PageRequest page = PageRequest.of(pageNo-1, pageSize);
		Page<Employee> findAll=empRepo.findAll(page);
		List<Employee> emps= findAll.getContent();
		System.out.println(emps);
		
		

	}

}