package com.encore.day09;

public class ObjectTest2 {
	public static void call () {
		Car c = new Car("BMW720", 7000);
		Car c2 = c;
		System.out.println(c);
		System.out.println(c2);
		c2.setModel("Grandeur");
		System.out.println(c.hashCode());
		System.out.println(c2);
		System.out.println(c2.hashCode());
		
	}
	public static void call2 () {
		Car c = new Car("BMW720", 7000);
		Car c2= null;
		try {
			c2 = (Car) c.clone();
		} catch (CloneNotSupportedException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		System.out.println(c);
		System.out.println(c2);
		System.out.println(c.hashCode());
		System.out.println(c2.hashCode());
		c2.setModel("Grandeur");
		System.out.println(c);
		System.out.println(c2);
		System.out.println(c.hashCode());
		System.out.println(c2.hashCode());
		
	}
	public static void call3 () throws CloneNotSupportedException {
		Car c = new Car("BMW720", 7000, new String[]{"하이패스", "네비게이션", "블랙박스"});
		Car c2= null;
		c2 = (Car) c.clone();
		System.out.println(c);
		System.out.println(c2);
		System.out.println(c.hashCode());
		System.out.println(c2.hashCode());
		c2.setModel("Grandeur");
		c.acc[0]="악세사리변경";
		System.out.println(c);
		System.out.println(c2);
		System.out.println(c.hashCode());
		System.out.println(c2.hashCode());
		
	}
	public static void main(String[] args) throws CloneNotSupportedException {
		call3();
	}
}
