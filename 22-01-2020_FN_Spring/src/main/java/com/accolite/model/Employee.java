package com.accolite.model;

public class Employee {
	private int empId;
	private String empName;
	private String empPos;

	public Employee(int empId, String empName, String empPos) {
		this.empId = empId;
		this.empName = empName;
		this.empPos = empPos;
	}

	public int getEmpId() {
		return empId;
	}

	public void setEmpId(int empId) {
		this.empId = empId;
	}

	public String getEmpName() {
		return empName;
	}

	public void setEmpName(String empName) {
		this.empName = empName;
	}

	public String getEmpPos() {
		return empPos;
	}

	public void setEmpPos(String empPos) {
		this.empPos = empPos;
	}

	@Override
	public String toString() {
		return "Employee [empId=" + empId + ", empName=" + empName + ", empPos=" + empPos + "]";
	}
}
