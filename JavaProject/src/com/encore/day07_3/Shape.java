package com.encore.day07_3;

public abstract class Shape {

	int numSides;
	
	public Shape() {}
	public Shape(int numSides) {
		this.numSides = numSides;
	}
	public int getNumSides() {
		return numSides;
	}
	public abstract double getArea();
	public abstract double getPerimeter();
}
