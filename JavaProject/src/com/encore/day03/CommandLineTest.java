package com.encore.day03;

public class CommandLineTest {

	public static void main(String[] nargs) {
		System.out.println("명령행 매개변수");
		System.out.println(nargs.length);
		for (int i=0; i< nargs.length; i++ ) {
			System.out.println("args["+i+"]= "+nargs[i]); //D:\BigData\JavaWork\JavaProject\bin\com\encore\day03
		}
		
		//2개의 숫자를 받아서 사칙연산 수행
		if (nargs.length !=2) {
			System.out.println("Bye");
			return; //함수를 빠져나가라..... 
		}
		
		//int type 으로 변환
		int num1 = Integer.parseInt(nargs[0]); 
		int num2 = Integer.parseInt(nargs[1]);
		System.out.println(" +  : " + (num1 + num2) );
		System.out.println(" -  : " + (num1 - num2) );
	}
}
