package com.encore.day02;

import java.util.Scanner;

public class Lab1 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Scanner sc = new Scanner(System.in);
		System.out.print("1보다 크고 10보다 작은 정수를 입력하세요");
		int var1 = sc.nextInt();
		if (var1 >=2 && var1 <= 9) {
			for (int i=var1 ; i <=9 ; i++) {
				System.out.printf("%d X %d = %d\t", var1, i, var1*i);
			}
			
		}
		else {
			System.out.println("잘못된 숫자가 입력되었습니다. 프로그램을 종료합니다. ");
		}
		sc.close();
		
	}

}
