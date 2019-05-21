package com.encore.day06;

public class EmpTest {
	public static void main(String[] args) {
		Employee e1 = new Employee("100", "현진우", "Marketing");
		Manager m1 = new Manager("100", "현진우", "Marketing", "manager");
		e1.print();
		m1.print();
		
		
	}
}
