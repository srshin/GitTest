package com.encore.day08;

public class RecTriangle extends Shape {

	double width;
	double height;
	
	public RecTriangle(double w, double h) {
		super(3);
		width = w;
		height = h; 
	}

	@Override
	double getArea() {
		return width * height * 0.5;
	}

	@Override
	double getPerimeter() {
		return width +height + Math.sqrt(width*width + Math.pow(height, 2));
	}

}
