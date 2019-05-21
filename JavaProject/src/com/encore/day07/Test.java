package com.encore.day07;

//Object class : toString() .... 주소 출력 : 패키지 이름.class이름@해시코드(=주소) hexa

class Car  extends Object {
	String model = "grandeur";

	@Override
	public String toString() {
		return "럭셔리 자동차" + model;
	}
	
}


public class Test {
	public static void main(String[] args) {
		String s = "자바";
		//String 도 objec를 상속받아 toString을 재정의하였음. ... sysout시 toString을 출력
		System.out.println(s);
		Car c = new Car(); 
		System.out.println(c); 
		BonusPointAccount acc = new BonusPointAccount("123", "sdfs", 100, 200);
		System.out.println(acc);
	}
}
