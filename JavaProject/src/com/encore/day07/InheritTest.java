package com.encore.day07;

class Parent{
	int a = 100;
	int c = 300; 
	
	void show() {
		System.out.println("Parent의 show method");
	}
}

class Child extends Parent {
	int b = 200; 
	String c ;
	
	void show() {
		System.out.println("Child의 show method");
	}
	
} 

public class InheritTest {

		public static void main(String[] args) {
			Parent p = new Child();
			System.out.println(p);
			System.out.println(p.a);
			System.out.println(((Child)p).b);
			p.show();
			Child ch = new Child();
			System.out.println(ch.c); //string으로 보임. 
			
			
		}
}
