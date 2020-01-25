package com.practice.dao;

import java.util.List;

import com.practice.model.Employee;

public interface EmployeeDAO {

	public void saveOrUpdate(Employee employee);

	public void delete(int id);

	public Employee get(int id);

	public List<Employee> list();
}
