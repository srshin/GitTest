package com.encore.day02;

public class BreakTest {

	public static void main(String[] args) {
		// break: switch 빠지기. 반복문 빠지기
		int count =0;
		while (true) {
			System.out.println("배고파 ~~~~~~~~~~~");
			count++;
			if (count==10) break;
		}

	}

}
