package com.encore.day07;

public class Duck {
	String name;
	int legs;
	double length; 
	
	
	
	public Duck(String name, int legs, double length) {
		super();
		this.name = name;
		this.legs = legs;
		this.length = length;
	}


	void fly() {
		System.out.println(this.getClass().getSimpleName()+"는"
				+ 
				"("
				+name 
				+ " )는 날지 않습니다. ");
	}
	void sing() {
		System.out.println(this.getClass().getSimpleName()+"는"
				+ 
				"("
				+name 
				+ " )는  소리내어 웁니다. ");
		
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}


	@Override
	public String toString() {
		return "Duck name=" + name + "입니다";
	}
	
	
	
	
}
