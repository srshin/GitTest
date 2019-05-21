package com.encore.day02;

public class PrintTest {
	
	public static void main(String[] args) {

		//출력 \n \t 
		System.out.print("아메리카노\n");
		System.out.print("카페라떼\t");
		System.out.println("카라멜마키아또");
		
		System.out.printf("아메리카노");
		System.out.printf("카페라떼");
		System.out.printf("카라멜마키아또");
		//format 
		System.out.println();
		System.out.printf("12345678901234567890\n");
		System.out.printf("%s\n", "아메리카노");
		System.out.printf("%20s\n", "카페라떼");
		System.out.printf("%-20s\n", "카라멜마키아또");
	}
}
