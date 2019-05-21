package com.encore.day06;

public class Shape {
	
	private int x;
	private int y; 
	
	public Shape () {}
	public Shape(int x, int y) {
		super();
		this.x = x; 
		this.y = y; 
	}
	public void draw() {
		System.out.println("x= " + x + "  y=" + y + "  에서 그리기 시작 ");
	}

}
