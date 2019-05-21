package com.encore.day04;
//틀 정의 = 설계도 = class
public class Car {
	
	
	//1. field :특징, 속성, 변수
	private String model;
	private String color;
	private int price; 
	//2. Constructor : 생성자
	//객체지향의 다형성 : 오버로딩 Overloading 이름은 같은데 모양이 다르다. 
	Car() {
		System.out.println("default 생성자에 의하여 car object가 만들어진다");
	}
	Car (String _model, String _color, int _price) {
		System.out.println("arg 3개를 갖는 생성자에 의하여 car object가 만들어진다");
		model = _model; 
		color = _color;
		price = _price; 
	}
	
	//3. Method : 기능
	public void carInfoPrint() {
		System.out.println("모델은 " + model);
		System.out.println("색깔은 " + color);
		System.out.println("가격은 " + price);
	}
	
	//4. Static Block
	
	//5. Inner Class
	

}
