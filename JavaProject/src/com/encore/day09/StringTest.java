package com.encore.day09;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

public class StringTest {
	public static void call() {
		String str = "자바 프로그래밍";
		System.out.println(str.charAt(3));
		System.out.println(str.substring(1, 3));
		
		for (int i=0 ; i< str.length(); i++)
			System.out.print(str.charAt(i));
	}
	public static void call2() {
		String str = "자바 프로그래밍";
		for (int i=0 ; i< str.length(); i++)
			System.out.print(str.substring(i,i+1));
	}
	
	public static void call3() {
		String str = "자바 프로그래밍";
		char[] arr = str.toCharArray();
		for (char c: arr)
			System.out.print(c);
	}

	public static void call4() throws UnsupportedEncodingException {
		String str = "자바 프로그래밍";
		byte[] arr = str.getBytes("UTF-8");
		for (byte c: arr)
			System.out.print(c);
		System.out.println();
		System.out.print(Arrays.toString(arr));
		String str2 = new String(arr, "UTF-8");
		System.out.println(str2);
	}

	static void call5 () {
		String str = "자바 프로그래밍";
		System.out.println(str.replace('자', '차'));
		System.out.println(str);
		String str2 = "   java Programming    ";
		System.out.println(str2.toUpperCase());
		System.out.println(str2);
		System.out.println("|"+str2.trim()+"|");
	}

	
	
	public static void call6() {
		int a = 100; 
		System.out.println(a+200);
		String s = String.valueOf(a); //a + ""
		System.out.println(s+200);
		
		
		
	}
	public static void main(String[] args) throws UnsupportedEncodingException {
		call6();
	}
}
