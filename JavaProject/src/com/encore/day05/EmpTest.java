package com.encore.day05;

import java.util.Date;

public class EmpTest {
	public static void main(String[] args) {
		Employee e1 = new Employee("100", "방서경");
		Employee e2 = new Employee("200", "배지수");
		e1.print();
		e2.print();
		e2.company = "안랩";
		Employee.company = "삼성"; 
		e1.print();
		e2.print();
		Employee[] emp = new Employee[5];
		
		emp[0] = new Employee("200", "문상수");
		emp[1] = new Employee("200", "문상수");
		emp[2] = new Employee("200", "문상수");
		emp[3] = new Employee();
		emp[4] =  new Employee("400", "박세환", "인사부", 500, new Date());
		for (Employee empElement : emp) {
			empElement.print();
		}	
		System.out.println("직원수  :" + Employee.count );
		

	}
}
