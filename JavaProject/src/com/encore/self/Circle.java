package com.encore.self;

class Circle extends Shape{

	double radius; 
	double circumference;
	
	
	public Circle() {
		super();
	}

	public Circle(String color, double radius) {
		super (color, "Circle");
		this.radius = radius; 
	}
	public double getRadius() {
		return radius;
	}
	public void setRadius(double radius) {
		this.radius = radius;
	}
	public double getCircumference() {
		return circumference;
	}
	public void setCircumference(double circumference) {
		this.circumference = circumference;
	}
	@Override
	public double calculateArea() {
		return Math.PI * radius * radius ;
	}
	@Override
	public double calculatePerimeter() {
		return Math.PI * radius * 2 ;
	} 
	
	
}
