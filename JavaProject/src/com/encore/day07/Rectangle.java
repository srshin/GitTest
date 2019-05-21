package com.encore.day07;


//추상 클래스를 상속받는 자식은 반드시 추상메스드를 구현할 의무가 있다. 
public class Rectangle extends Shape {

	int width; 
	int height; 

	
	public Rectangle(int x, int y, int width, int height) {
		super(x, y);
		this.width = width;
		this.height = height;
	}

	
	public Rectangle(String color, int width, int height) {
		super(color, "Rectangle");
		this.width = width;
		this.height = height;
	}


	@Override
	public int getArea() {
		return width * height;
	}


	@Override
	public double calculateArea() {
		return width * height ;
	}


	@Override
	public double calculatePerimeter() {
		return ( width + height ) * 2;
	}

}
