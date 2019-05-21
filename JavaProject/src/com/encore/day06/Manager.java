package com.encore.day06;

public class Manager extends Employee {
	
	String job;

	public Manager(String empId, String empName, String dept, String job) {
		super(empId, empName, dept);  //부모의 생성자를 호출하라. 
		this.job = job;
	}
	public void print() {
		super.print();
		System.out.println(job);
	}
	
}
