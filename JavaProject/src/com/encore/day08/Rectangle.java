package com.encore.day08;

public class Rectangle extends Shape  implements Resizable {

	double width; 
	double height; 
	
	public Rectangle(double w, double h) {
		super(4);
		width = w; 
		height = h; 
	}
	@Override
	double getArea() {
		return width * height; 
	}

	@Override
	double getPerimeter() {
		return width *2 + height * 2;
	}

	@Override
	public void resize(double s) {
		width *=s;
		height *=s; 
	}
}
