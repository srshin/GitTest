package com.encore.day08;

public class Television extends Parent implements RemoteControl{

	@Override
	public void turnOn() {
	System.out.println("Television의 전원을 켠다");
		
	}

	@Override
	public void turnOff() {
		System.out.println("Television의 전원을 끈다");
		
	}

	@Override
	public void setting() {
		System.out.println("Television을 setting합니다");
	}
	

}
