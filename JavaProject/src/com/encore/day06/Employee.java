package com.encore.day06;

public class Employee {
	String empId;
	String empName;
	String dept;
	
	public Employee() {
	}

	public Employee(String empId, String empName, String dept) {
		this.empId = empId;
		this.empName = empName;
		this.dept = dept;
	}

	public void print() {
		System.out.println("--------------직원정보입니다----------------");
		System.out.println(empId);
		System.out.println(empName);
		System.out.println(dept);
	}
}
