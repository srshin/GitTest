package com.encore.day02;

import java.util.Scanner;

public class 배수연습 {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		// 어떤 수가 7의 배수인가요?
		Scanner sc = new Scanner(System.in);
		int count = 0;

		while (true) {
			System.out.print("숫자를 입력하세요 >>>");
			int su = sc.nextInt();
			if (su == -1 )
			{
				System.out.println("7의 배수는 " + count + "개 입니다");
				System.out.println("프로그램이 종료합니다");
				break;
			}
			if (su % 7 == 0) {
				count++;
				System.out.println("7의 배수입니다.");
			} else {
				System.out.println("7의 배수가 아닙니다.");
			}
		}
	}

}
