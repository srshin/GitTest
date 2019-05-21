package com.encore.self;

class Rectangle  extends Shape {

	int length; 
	int width;
	
	public Rectangle() {
		super();
	}
	public Rectangle(String color, int length, int width) {
		super (color, "Rectangle");
		this.length = length;
		this.width = width;
	}
	public int getLength() {
		return length;
	}
	public void setLength(int length) {
		this.length = length;
	}
	public int getWidth() {
		return width;
	}
	public void setWidth(int width) {
		this.width = width;
	}
	@Override
	public double calculateArea() {
		return length * width;
	}
	@Override
	public double calculatePerimeter() {
		return length *2 + width * 2;
	} 
	
}
