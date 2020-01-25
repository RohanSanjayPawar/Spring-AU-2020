package com.practice.model;

public class Employee {
	private int id;
	private String firstName;
	private String lastName;
	private String designation;
	private String department;

	public Employee() {

	}

	public Employee(String firstName, String lastName, String designation, String department) {
		this.firstName = firstName;
		this.lastName = lastName;
		this.designation = designation;
		this.department = department;
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFirstName() {
		return firstName;
	}

	public void setFirstName(String firstName) {
		this.firstName = firstName;
	}

	public String getLastName() {
		return lastName;
	}

	public void setLastName(String lastName) {
		this.lastName = lastName;
	}

	public String getDesignation() {
		return designation;
	}

	public void setDesignation(String designation) {
		this.designation = designation;
	}

	public String getDepartment() {
		return department;
	}

	public void setDepartment(String department) {
		this.department = department;
	}

	@Override
	public String toString() {
		return "Employee [id=" + id + ", firstName=" + firstName + ", lastName=" + lastName + ", designation="
				+ designation + ", department=" + department + "]";
	}
}
