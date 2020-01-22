package com.accolite.portal;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.stereotype.Controller;

import com.accolite.model.Department;
import com.accolite.service.EmployeeService;
import com.accolite.service.PointService;
import com.accolite.config.AppConfig;

@Controller
@ComponentScan(basePackages = "com.accolite.*")
public class App {
	private static ApplicationContext context;
	
	public static void main(String args[]) {
		context = new ClassPathXmlApplicationContext("spring.xml");
		
		// create a class Employee, Employee service. EmployeeService class should have a method called getAllEmployees() 
		// where u can mock data and return a list of employees. Use AOP concept and find how much time that method took to execute.
		EmployeeService employeeService = context.getBean(EmployeeService.class);
		System.out.println("All Employees\n"+employeeService.getAllEmployees());
		
		
		// DI, Using XML way inject a dependency for Map object. Map key is a Integer and Value is Employee object.
		System.out.println("\n\n\n===========================================");
		System.out.println("Maps of all employees of department I.T: ");
		Department department = context.getBean(Department.class);
		System.out.println(department);
		
		// use java annotation based way to inject variable x and y for a point class. But the value should come from Property file
		System.out.println("\n\n\n===========================================");
		context = new AnnotationConfigApplicationContext(AppConfig.class);
		PointService pointService = context.getBean(PointService.class);
		pointService.printPoint();
	}
}