package com.encore.day02;

public class Gugudan {

	public static void main(String[] args) {
		// 2단 출력
		// 2*1 2*2 2*3 ..... 2*9
		for (int i = 1; i <= 9; i++) {
			if (i == 3)
				continue;
			for (int j = 2; j <= 9; j++) {
				System.out.printf("%dX%d=%d\t", j, i, j*i);
			}
			System.out.println();
		}

	}

}
