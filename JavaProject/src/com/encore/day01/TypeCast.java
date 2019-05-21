package com.encore.day01;

public class TypeCast {

	public static void main(String[] args) {
		//1. 자동 형변환
		byte by = 100;
		int i = 200;
		// by=i; Error 
		//char (2) , boolean (1) 
		//byte < short < int (4) < long (8) < float (4) < double (8) 
		i = by;  //자동으로 형변환 일어남 
		System.out.println("byte를 int로 변경 " + i); //문자 + 숫자 => 문자 
		
		//2. 강제형변환
		by =(byte)i;
		System.out.println("int를 byte로 변경"+ by );
		
		i=130;
		by =(byte)i; // 변환 가능
		System.out.println("int를 byte로 변경"+ by ); //값이 변형되어 데이타 손실 발생
		
		double d=3.14;
		int i2 = (int)d;
		System.out.println("double을 int로 변경 "+ i2);
		System.out.println("원 데이타 "+ d );
		
		char ch ='A';
		byte by2 ;
		// ch = by2;  Error 발생 ! 
		
		by2 = (byte)ch;
		System.out.println(by2);
		
		ch++;
		ch++; // OK! 
		// ch = ch + 1; Error !
		int int3 = ch + 1; 
		ch = (char)(ch+1);
		
		
		//int(4) <-> char(2) 
		int i3 = 65;
		char ch2 = 'B';
		i3 = ch2; 
		System.out.println("자동변환 i="+i3);
		i3++;
		//강제
		ch2=(char)(i3);
		System.out.println("강제형변환"+ch2);

		{
		//작은 타입이 큰타입으로 자동 형변환 
		int a = 100;
		double b = 3.14;
		double result = a + b;
		System.out.println(result);
		}
		{
		//큰타입은  강제 형변환 필요  
		int a = 100;
		
		double b = 3.14;
		int result = a + (int)b;
		System.out.println(result);
		}
	}

}
