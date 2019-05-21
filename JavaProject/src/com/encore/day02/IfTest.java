package com.encore.day02;

public class IfTest {

	public static void call2() {

		int total = 95;
		String grade;
		System.out.println(total / 10);
		switch (total / 10) {
		case 10:
		case 9:
			grade = "A";
			break;
		case 8:
			grade = "B";
			break;
		case 7:
			grade = "C";
			break;
		case 6:
			grade = "D";
			break;
		default:
			grade = "F";
			break;
		}
		System.out.println("학점은"+grade+"입니다");
	}

	public static void call() {
		// 점수: 90이상이면 "A" 80이상 "B" 70이상 "C" 60이상 "D" 나머지 "F"
		int total = 95;
		String grade;

		if (total >= 90) {
			if (total >= 95) {
				grade = "A+";
			} else {
				grade = "A-";
			}

		} else if (total >= 80) {
			grade = "B";

		} else if (total >= 70) {
			grade = "C";

		} else if (total >= 60) {
			grade = "D";

		} else {
			grade = "F";

		}
		System.out.println("당신의 학점은 " + grade + "입니다");
	}

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		call2();

	}

}
