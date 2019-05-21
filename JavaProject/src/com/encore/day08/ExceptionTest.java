package com.encore.day08;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class ExceptionTest {
	public static void  call2 () {
		try {
			int[] arr = new int[3]; 
			arr[0]= 100;
			arr[1]= 200;
			
			Shape s = new Rectangle(4, 2);
			RecTriangle r = (RecTriangle)s;
		} catch (ArrayIndexOutOfBoundsException e) {
			
		} catch (NullPointerException e) {
			System.out.println("null pointer가 사용되었습니다");
		} catch (ArithmeticException e) {
			System.out.println("연산이 잘못되었습니다");
		} catch (ClassCastException e) { 
			System.out.println("형변환이 잘못되었습니다");
		} catch (Exception e) { 
			System.out.println("기타 오류가 생겼습니다");
		}
	}

	public static void call3() {
		try {//컴파일시에  반드시 해결해야하는 Excection <-RuntimeException이외
			Class cc = Class.forName("com.encore.day08.Rectangle2");
			System.out.println();
		} catch (ClassNotFoundException e ) {
			e.printStackTrace();
		} finally  {
			System.out.println("반드시 와야 하는 기준");
		}
		
	}
	
	public static void  call4()  throws ArithmeticException {
		try {
			int result = 10 / 0;
			
		} catch (Exception e ) {
			
		}
		
	}
	
	public static void  call5() throws IOException  {

		FileInputStream fi = new FileInputStream("./src/com/encore/day08/Rectangle.java");
		
		int i;
		while ((i=fi.read()) !=-1) {
			System.out.print((char)i);
		}
		fi.close();
	}
	
	
	public static void  call (int a, int b) {
		System.out.println("연산 수행합니다");
		try {
			System.out.println(a+b);
			System.out.println(a-b);
			System.out.println(a/b);
			System.out.println(a*b);
		} catch (ArithmeticException e) { // RuntimeException or Exception
			System.out.println("연산이 잘못되었습니다");
		} finally {
			System.out.println("예외 발생 무관하게 무조건 수행");
		}
		
	}
	public static void main(String[] args) throws ArithmeticException {
		System.out.println("시작");
		//call(10, 0);
		try {
			call5();
		} catch (IOException e ) {
			System.out.println("파일 에러 ");
		}
		System.out.println("종료");
	}
}
