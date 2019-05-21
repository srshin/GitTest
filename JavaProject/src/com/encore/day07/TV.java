package com.encore.day07;

public interface TV {

	//1. 상수 public static final
	int KBS =9;
	public static final int SBS = 6;
	int MBC = 11; 
	
	//2. 추상 메서드 public abstract 
	public abstract void powerOn(); 
	void powerOff(); 
}
