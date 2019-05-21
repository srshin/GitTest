package com.encore.day09;

public class ObjectTest {
	
	public static void main(String[] args) {
		call4();
	}
	public static void call4 () {
		Person obj1 = new Person("신상림","f", 20);
		Person obj2 = new Person("신상림","f", 20);
		String obj3 = new String("grand");
		
		System.out.println(obj1);
		System.out.println(obj1.toString());

		System.out.println(obj2);
		System.out.println(obj2.toString());
		
		System.out.println(obj1 == obj2);
		System.out.println(obj1.equals(obj2));
		System.out.println(obj1.equals(obj3));
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		
	}
	
	public static void call3 () {
		Car obj1 = new Car("그랜져", 5000);
		Car obj2 = new Car("그랜져", 5000);
		String obj3 = new String("grand");
		System.out.println(obj1);
		System.out.println(obj1.toString());

		System.out.println(obj2);
		System.out.println(obj2.toString());
		
		System.out.println(obj1 == obj2);
		System.out.println(obj1.equals(obj2));
		System.out.println(obj1.equals(obj3));
		System.out.println(obj1.hashCode());
		System.out.println(obj2.hashCode());
		
	}
	public static void call2 () {
		String obj1 = new String("고구마");
		String obj2 = new String("고구마");
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj1 == obj2);
		System.out.println(obj1.equals(obj2));
	}
	public static void call () {
		Object obj1 = new Object();
		Object obj2 = new Object();
		System.out.println(obj1);
		System.out.println(obj2);
		System.out.println(obj1 == obj2);
		System.out.println(obj1.equals(obj2));
	}
}
