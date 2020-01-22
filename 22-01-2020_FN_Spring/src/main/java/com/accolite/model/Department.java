package com.accolite.model;

import java.util.Map;

public class Department {
	private String dept_name;

	private Map<Integer, Employee> employees;

	public Department(String dept_name, Map<Integer, Employee> employees) {
		this.dept_name = dept_name;
		this.employees = employees;
	}

	public Map<Integer, Employee> getEmployees() {
		return employees;
	}

	public void setEmployees(Map<Integer, Employee> employees) {
		this.employees = employees;
	}
	
	public String getDept_name() {
		return dept_name;
	}

	public void setDept_name(String dept_name) {
		this.dept_name = dept_name;
	}

	@Override
	public String toString() {
		return "Department [dept_name=" + dept_name + ", employees=" + employees + "]";
	}
}
