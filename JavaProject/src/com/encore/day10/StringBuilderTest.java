package com.encore.day10;

public class StringBuilderTest {

	
	public static void call() {
		String s = "오늘의 점심" ;
		//메모리 낭비가 생김 
		s += "시간은 원래대로 한시" ;
		System.out.println(s);
	}
	public static void call3(String s) {
		
	}

	public static void call2() {
		//StringBuilder는 가변문자열이다. 결합연산자 +를 제공하지 않음.  
		//StringBuilder s = "오늘의 점심" ;
		StringBuilder s = new StringBuilder("오늘의 점심") ;
		//s += "시간은 원래대로 한시" ;
		s.append("시간은 원래대로 한시");
		System.out.println(s);
//		call3(s.toString());
//		call3(s);  ERROR!!!
		call3(new String(s));
	}
	public static void main(String[] args) {
		call2();
	}
}
