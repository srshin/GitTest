package com.encore.day07;

public class ShapeTest2 {
	public static void main(String[] args) {
		Shape s = new Circle("red", 4);
		System.out.println(s);
		if (s instanceof Circle) 
		System.out.println(((Circle)s).getRadius()); 
	}
}
