package com.encore.day08;

public class MyExceptionTest {
	public static void call(int age) throws MyException {
		//throw는 발생하다
		//throws는 던지다
		if (age <=10) throw new MyException("너무 어려요");
		
		
	}
	public static void main(String[] args) {
		try {
			call(10);
		} catch (MyException e) {
			e.printStackTrace(); //에러가 난 과정
			System.out.println(e.getMessage());
		}
		System.out.println("메인 끝 ");
		
	}
}
