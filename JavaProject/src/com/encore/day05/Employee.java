package com.encore.day05;

import java.util.Date;

public class Employee {
	
	static String company="엔코어 시스템";   //static 이면 공유하는 데이타가 됨. 각 인스턴스별로 생성되지 않고 클래스 내에 한개만 형성 

	String empId;
	String empName;
	String dept; 
	int salary; 
	Date hireDate; 
	static int count = 0;
	
	public Employee () {
		this (null, null, null, 0, null); //하나의 생성자가 다른 모양의 생성자를 호출 
	}
	public Employee (String empId, String empName) {
		this (empId, empName, null, 100, new Date()); //하나의 생성자가 다른 모양의 생성자를 호출 
	}
	

	public Employee(String empId, String empName, String dept, int salary, Date hireDate) {
		super();
		System.out.println("직원이 등록되었습니다");
		count++; 
		this.empId = empId;
		this.empName = empName;
		this.dept = dept;
		this.salary = salary;
		this.hireDate = hireDate;
	}
	
	public void print () {
		System.out.println("====================");
		System.out.println("회사이름 " + company);
		System.out.println("Employee [empId=" + empId + ", empName=" + empName + ", dept=" + dept + ", salary=" + salary
				+ ", hireDate=" + hireDate + "]");
		
		
		
	}
	
}
