package com.encore.day06;

public class StaticTest {

	String var1 = "java";
	static String var2 = "wdb";
	
	public static void main(String[] args) {
		System.out.println(var2);
		StaticTest aa = new StaticTest();
		System.out.println(aa.var1);
		
	}
}
