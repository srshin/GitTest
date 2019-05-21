package com.encore.day04;

public class ParkingManagement {

	public static void call2() {
		//1. 객체 참조 변수를 선언
		Car c;
		String str; 
		//2. 객체 생성. 생성시 자동으로 초기화 된다. string은 null로 int는 0으로 
		c= new Car(); 
		str = new String( ); 
		//3. 객체 사용
		c.carInfoPrint();
		//1. 객체 참조 변수를 선언
		Car c2;
		//2. 객체 생성. 생성시 자동으로 초기화 된다. string은 null로 int는 0으로 
		c2= new Car("BMW520", "White", 7000); 
		//3. 객체 사용
		System.out.println(c2);
		c2.carInfoPrint();
	}
	
	public static void main(String[] args) {
//		call ();
		call2 ();
		
		
	}
	
}
