package com.encore.day06;

public class Rectangle extends Shape{
	int width; 
	int height; 
	public Rectangle(int x, int y, int width, int height) {
		super (x,y); //생성자 호출 
		this.width = width;
		this.height = height;
	}
	
	public void draw() { //overriding 
		super.draw();   //method 호출
		System.out.println("width =" + width + " height =" + height + " 그리기 ");
	}
	
	
	
}
