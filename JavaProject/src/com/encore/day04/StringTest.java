package com.encore.day04;

public class StringTest {
	public static void main(String[] args) {
		String s1 = new String(); 
		String s2 = new String("Encore");
		byte[]arr= {65,66,67,68};
		String s3=  new String(arr);
	
		System.out.println(s3);
		
		char[] arr2 =  {'a', 'b', 'c', 'd' };
		String s4= new String(arr2);
		System.out.println();
		
		
	}
}
