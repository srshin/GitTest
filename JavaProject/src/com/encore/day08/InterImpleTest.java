package com.encore.day08;

public class InterImpleTest {
	public static void main(String[] args) {
		Inter1 i1 = new InterImple();
		i1.print();
		i1.print2();
		i1.print3();
		Inter2 i2 = new InterImple();
		i2.print5();
		i2.print6();
		i2.print7();
		System.out.println(i1 instanceof Inter1); //true
		System.out.println(i1 instanceof Inter2); //true
		System.out.println(i1 instanceof InterImple); //true
		Inter1.print4(); //static이므로 class 이름으로만 접근 가능. 
		
	}
}
