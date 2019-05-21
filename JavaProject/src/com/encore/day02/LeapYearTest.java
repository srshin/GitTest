package com.encore.day02;

import java.util.Scanner;

public class LeapYearTest {

	/*
	 * 4의 배수인 해는 윤년 4의 배수이면서 100의 배수인 해는 윤년이 아님 100의 배수이면서 400의 배수인 해는 윤년
	 */
	public static void main(String[] args) {

		Scanner sc = new Scanner(System.in);

		while (true) {
			System.out.print("연도를 입력하세요--->");
			int year = sc.nextInt();
			if ( year < 0  ) {
				System.out.println("연도는 음수가 안됩니다");
				break;
			}
			System.out.print("월을 입력하세요--->");
			int month = sc.nextInt();

			String message = "";
			int lastDay = 0;
			;
			switch (month) {
			case 1:
			case 3:
			case 5:
			case 7:
			case 8:
			case 10:
			case 12:
				lastDay = 31;
				break;
			case 2:
				// 논리연산자의 우선순위 ! > && > ||
				if (year % 4 == 0 && year % 100 != 0 || year % 400 == 0) {
					message = "윤년입니다";
					lastDay = 28;

				} else {
					message = "윤년이 아닙니다";
					lastDay = 29;
				}
				break;
			case 4:
			case 6:
			case 9:
			case 11:
				lastDay = 30;
				break;
			default:
				message = "월 입력이 잘못되었습니다.";
				break;
			}

			System.out.println(message);
			System.out.println(year + "년 " + month + "월" + " 말일은 " + lastDay + "일 입니다. ");
		}
		System.out.println("프로그램이 종료되었습니다");
		sc.close();
	}

}
