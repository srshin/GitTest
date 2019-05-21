package com.encore.day08;

public class Refig implements RemoteControl{

	@Override
	public void turnOn() {
		System.out.println("냉장고의 전원을 켠다 ");
	}

	@Override
	public void turnOff() {
		System.out.println("냉장고의 전원을 끈다 ");
		
	}

}
