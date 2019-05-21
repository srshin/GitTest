package com.encore.day07;

public class Sparrow {
	String name;
	int legs;
	double length; 
	
	
	
	public Sparrow(String name, int legs, double length) {
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
				+ " )는 날아다닙니다. ");
	}
	void sing() {
		System.out.println(this.getClass().getSimpleName()+"는"
				+ 
				"("
				+name 
				+ " )는  소리내어 웁니다. ");
		
	}


	@Override
	public String toString() {
		return "Sparrow  name=" + name+ "이 입니다. ";
	}


	public String getName() {
		return name;
	}


	public void setName(String name) {
		this.name = name;
	}
	
	
	
	
}
