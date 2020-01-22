package com.accolite.aspect;

import java.time.*;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.After;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

@Aspect
public class EmployeeAspect {
	
	static LocalTime localTime;
	
	@Before("execution(* com.accolite.service.EmployeeService.getAllEmployees(..))")
	public void beforeGet(JoinPoint joinPoint) { 
		localTime = LocalTime.now();
		System.out.println("Employee Aspect Before: " + joinPoint.getSignature().getName()+" Time: "+localTime.toString());
	}
	
	@After("execution(* com.accolite.service.EmployeeService.getAllEmployees(..))")
	public void afterGet(JoinPoint joinPoint) {
		
		LocalTime currentTime = LocalTime.now();
		long elapsed = Duration.between(localTime, currentTime).toNanos();
		
		System.out.println("Employee Aspect After: " + joinPoint.getSignature().getName()+" Time: "+LocalTime.now().toString());
		System.out.println("Time elapsed in nanoseconds: "+elapsed);
	}
}
