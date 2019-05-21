package com.encore.day05;

public class MethodTest {
	
	
	//overloading of method
	public static int sum (int a, int b ) {
		 return a+b; 
	}

	public static String sum (String a, String b ) {
		 return a+b; 
	}

	public static String sum (String a, String b,  String c) {
		 return a+b+c; 
	}
	public static double sum (double a, double b, double c) {
		return a+b+c;
		
	}
	public static int sum (int...data) //변수의 갯수가 가변 int[] data와 동일 
	{ 
		int total = 0; 
		for (int intE : data) {
			total += intE; 
		}
		return total; 
		
		
	}
	public static void main(String[] args) {
		int a = sum(10,20);
		int b = sum(100,200);
		System.out.println(sum(a,b));
		
		String ret3 = sum("엔코어", "교대역");
		System.out.println(ret3);
		
		double ret5 = sum(1, 3, 4);
		System.out.println(ret5);
		
		int ret7 = sum (1,2,3,4,2,2,3,3,2,1,2);
		System.out.println(ret7);
	}
}
