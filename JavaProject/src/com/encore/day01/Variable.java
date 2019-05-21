package com.encore.day01;

public class Variable {
	
	public static void test() {
		int score = 400;
		System.out.println(score);
	}

	public static void main(String[] args) {
	System.out.println("메인 시작 ");
	test();
	//1. 변수 선언
	int score ; // -2giga ~ 2 giga
	//2. 변수에 값 할당
	score = 100 ;
	//3. 변수 사용
	System.out.println(score);
	
	//선언과 할당 같이
	int score2 = 200;
	int total = score + score2;
	System.out.println(total);
	
	byte b = 127;// 1 byte 128 x
	short s = 32767; //2 byte
	int i = 2147483647 ; //4 byte (기본)
	long lo = 2147483648L; // 8byte l(L)을 붙여줘야 함. 
	float f = 3.14f ; // 4 byte f(F) 붙여줘야 함
	double d = 3.14 ; // 8 byte;(기본) 
	boolean bb = 1>2; //false / true
	char c = ' '; //한 자만
	String str = "자바" ;
	System.out.println(bb);
	
	
	System.out.println("메인 끝 ");

	}

}
