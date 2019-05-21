package com.encore.day09;

import java.util.Date;

public class SystemTest {
	public static void main(String[] args) {
		System.out.println(new Date(System.currentTimeMillis()));
		long a = System.currentTimeMillis();
		for (int i=1;i <=1000000000; i++);
		long b = System.currentTimeMillis();
		System.out.println(b-a);
		
		Class c =null;
		
	}
}
