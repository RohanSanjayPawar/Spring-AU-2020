package com.practice.test;

import static org.mockito.Mockito.doAnswer;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import org.junit.Assert;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.runners.MockitoJUnitRunner;

import com.practice.dao.EmployeeDAO;
import com.practice.dao.EmployeeDAOImpl;
import com.practice.model.Employee;

@RunWith(MockitoJUnitRunner.class)
public class TestEmployeeDAO {
	@Mock
	EmployeeDAO testEmpDAO = mock(EmployeeDAO.class);
	
	@Mock
	Employee employee;

	private Employee testEmp1 = new Employee("Rohan", "Pawar", "Manager", "I.T");
	private Employee testEmp = new Employee();

	private List<Employee> employeeList = new ArrayList<>();

	@Test
	public void testEmployeeDao() throws SQLException {
		this.employeeList.add(new Employee("Omkar", "Raykar", "Intern", "SDE"));
		this.employeeList.add(new Employee("Darshan", "Patil", "Associate Developer", "I.T"));

		// Add the behavior of Employee DAO to perform CRUD Operations
		doAnswer(invocation -> {
			// Check if the given employee is the new manager of the I.T department at Obeya
			// Elan office of Accolite India Software Pvt. Ltd.
			testEmp = (Employee) invocation;
			// Designation = Manager
			Assert.assertEquals(this.testEmp.getDesignation(), "Manager");
			// Department = I.T
			Assert.assertEquals(this.testEmp.getDepartment(), "I.T");
			// Id is not null
			Assert.assertNotNull(this.testEmp.getId());

			System.out.println("New manager of Accolite Obeya Elan is: " + this.testEmp);
			return null;
		}).when(testEmpDAO).saveOrUpdate(employee);

		doAnswer(invocation -> {
			Employee tempEmployee = (Employee) invocation;
			// Make sure update is on right employee with Id = 0
			Assert.assertEquals(tempEmployee.getId(), 3);
			System.out.println("Update on employee: " + tempEmployee.toString());
			return null;
		}).when(testEmpDAO).saveOrUpdate(employee);

		doAnswer(invocation -> {
			// Check if the ID that is to be deleted doesn't belong to the Manager
			Employee tempEmployee = (Employee) invocation;
			Assert.assertFalse(tempEmployee.getId() == 0);
			System.out.println("Employee Deletion for id= " + invocation);
			return null;
		}).when(testEmpDAO).delete(1);

		when(testEmpDAO.get(0)).thenReturn(this.testEmp1);

		when(testEmpDAO.list()).thenReturn(this.employeeList);

		// test the CRUD functionalities
		testEmpDAO.saveOrUpdate(new Employee("Rohit", "Gonasalves12", "Intern", "SDE"));
		testEmpDAO.saveOrUpdate(new Employee(0, "Rohit", "Gonsalves", "Intern", "I.T"));
		Employee employee = testEmpDAO.get(0);
		List<Employee> list = testEmpDAO.list();
		Assert.assertEquals(list.size(), 2);
		System.out.println(employee);
	}

}
