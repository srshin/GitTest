package com.encore.day02;

public class ForTest {
	// 1부터 10까지 출력
	public static void call () {
		for (int i=1;i<=10;i++) {
			System.out.println(i);
		}
	}
	
	// 1부터 10까지 출력
	public static void call2 () {
		int i=1;
		while(true) {
			if (i>10) break;
			System.out.println(i);
			i++;
		}
	}

	// 1부터 10까지 출력
	public static void call3 () {
		int i=1;
		do {
			System.out.println(i);
			i++;
		} while(i<=10);
	}

	
	public static void main(String[] args) {
		call3();

	}

}
