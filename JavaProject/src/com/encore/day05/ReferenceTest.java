package com.encore.day05;

import javax.swing.plaf.synth.SynthSeparatorUI;

public class ReferenceTest {
	public static int add (int num1, int num2) {
		return num1 + num2 ; 
		
	}
	public static void swap (int a, int b) {
		int temp = a;
		a=b;
		b=temp;
		
	}
	public static void swap (int[] arr) {
		int temp = arr[0];
		arr[0]=arr[1];
		arr[1] =temp;
		
	}

	
	public static void main(String[] args) {
		int ret = add (10,20);
		System.out.println(ret);
		
		int a=3;
		int b=6;
		System.out.println("a="+ a+" b= "+b);
		swap(a,b);
		System.out.println("a="+ a+" b= "+b);
		
//		=====================================
		int[] arr = new int[2];
		arr[0] = 3;
		arr[1] = 4;
		System.out.println("arr[0] = " + arr[0] + "  arr[1] = " + arr[1]);
		swap(arr);
		System.out.println("arr[0] = " + arr[0] + "  arr[1] = " + arr[1]);
//		=====================================
		Employee emp = new Employee("12345", "박정은"); 
		print (emp);
		System.out.println(emp.dept);
	}
	static void print (Employee emp) {
		System.out.println(emp.empId);
		System.out.println(emp.empName);
		emp.dept ="빅데이타 분석 ";
		
		
		
	}
}
