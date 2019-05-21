package com.encore.day08;

public abstract class Shape {

	int numSides ; // 변의 수 
	public Shape(int numSides) {
		this.numSides = numSides;
	}
	public int getNumSides() {
		return numSides;
	}
	abstract double getArea();
	abstract double getPerimeter();

}
