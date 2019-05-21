package com.encore.self;

public class ExceptionTest {
	public static void main(String[] args) {
		try {
		throw new RuntimeException();
		} catch (RuntimeException e) {
			System.out.println("runtime error 발생 ");
		}
	}
}
