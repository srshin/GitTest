package com.encore.day08;
//상수 +추상 메서드 + default 메서드 + static 메서드
public interface RemoteControl {
	public static final String HUB_ID = "123";
	String HUB_NAME = "Home Network"; //public static final 무조건 붙음 !
	
	public abstract void turnOn();
	void turnOff(); //public abstract 이 무조건 붙음 
	
	public default void setting() { //public은 생략 가능함. 
		System.out.println("Setting합니다");
	}
	static void print() {
		System.out.println("프린트");
	}
	
}
