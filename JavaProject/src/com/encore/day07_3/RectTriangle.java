package com.encore.day07_3;

public class RectTriangle extends Shape {

	double width; 
	double height;
	
	public RectTriangle(double w, double h) {
		width = w;
		height = h; 
	}
	
	@Override
	public double getArea() {
		return width * height * 0.5;
	}

	@Override
	public double getPerimeter() {
		return (width + height) + Math.sqrt(width*width + height*height);
	}
	
}
