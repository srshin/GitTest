package com.encore.day05;
// 접근권한
// public  : 다른 패키지에서 접근 가능 
// 생략          : 같은 패키지에서만  접근 가능. 다른 패키지에서는 import해도 불가 
// private : 클래스 내부에서만 접근 가능. 
// 활용바법 
// static : class 변수 

public class Car {
	public String model; 
	private int price;
	public Car () {} // public : 다른 패키지에서 접근 가능 

	public void print () {
		
	}
	

}
class Test {
	
	void show() {
		Car c = new Car(); 
		c.model ="sonata";
		//c.price  = 100000; ERROR ! 
	}
}
