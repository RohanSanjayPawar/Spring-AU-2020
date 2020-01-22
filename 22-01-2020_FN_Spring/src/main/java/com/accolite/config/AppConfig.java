package com.accolite.config;

import java.util.*;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;

import com.accolite.model.Employee;


@Configuration
@ComponentScan(basePackages = "com.accolite.*")
public class AppConfig {

	@Bean(name = "Employee")
	public List<Employee> getEmployees() {
		ArrayList<Employee> employees = new ArrayList<>();
		employees.add(getEmployee1());
		employees.add(getEmployee2());
		employees.add(getEmployee3());
		
		return employees;
	}

	private Employee getEmployee1() {
		return new Employee(101, "Rohan", "Manager");
	}
	
	private Employee getEmployee2() {
		return new Employee(102, "Rohit", "Intern");
	}
	
	private Employee getEmployee3() {
		return new Employee(103, "Omkar", "Intern");
	}

}