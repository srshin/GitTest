package com.encore.day08;

public class MyException extends Exception{

	String msg;
	public MyException(String msg) {
		super(msg);
	}
	public void print () {
		System.out.println("나의 예외입니다");
	}
	
}
