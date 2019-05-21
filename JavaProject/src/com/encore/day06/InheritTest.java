package com.encore.day06;

class Parent extends Object { //extends Object를 쓰지 않아도 무조건 상속받음. 
	String name; 
	Parent () {}
	Parent(String a ) {
		super() ; //숨어 있음. 
		System.out.println("Parent의 생성자");
		name = a; 
	}
	public void print() {
		System.out.println("parent에서  name :  " + name);
	}
	
}

class Child extends Parent{
	String name2;
	
	Child (String a, String b ) {
		super(a);
		name2=b;
		System.out.println("child의 생성자");
	}
	public void print2 () {
		System.out.println("child에서  name2 : " + name2);
		print();
		System.out.println();
		
	}
	
}

public class InheritTest {
	public static void main(String[] args) {
		Child c = new Child("김", "박");
		c.print();
		c.print2(); 
		
	}

}
