package com.encore.day07;

public class Circle extends Shape {

	int radius; 
	
	
	public Circle(String color,int radius) {
		super(color, "Circle");
		this.radius = radius;
	}

	public Circle(int x, int y, int radius) {
		super(x, y);
		this.radius = radius;
	}

	
	public int getRadius() {
		return radius;
	}

	public void setRadius(int radius) {
		this.radius = radius;
	}

	@Override
	public int getArea() {
		return (int)(radius * radius * Math.PI);
	}

	@Override
	public double calculateArea() {
		return radius * radius * Math.PI;
	}

	@Override
	public double calculatePerimeter() {
		return 2* radius * Math.PI;
	}

}
