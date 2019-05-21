package com.encore.day07;

public abstract class Shape { //멤버 중에 추상이 하나라도 있으면 추상으로 선언해줘야 함. 
							  // instance화할 수 없음. 자식 클래스를 통해서만 사용됨. 
	
	String color; 
	String type; 
	int x;
	int y;
	public Shape () {}
	public Shape (int x, int y ) {
		//super();
		this.x = x;
		this.y = y; 
	}
	public Shape (String color, String type) {
		this.color = color; 
		this.type = type; 
	}
	
	@Override
	public String toString() {
		return "color=" + color + ", type=" + type;
	}
	public abstract double calculateArea(); 
	public abstract double calculatePerimeter(); 
	
	
	//추상 메서드-- 정의는 있고 구현은 없음 
	//구현은 이 클래스를 상속받은 자식이 한다. 
	public abstract int getArea ();
	
	
	//일반 메서드 
	public void print () {
		System.out.println("x=" + x);
		System.out.println("y=" + y);
	}
}
