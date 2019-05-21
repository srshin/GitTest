package com.encore.day02;

public class PrimeNumber {

	public static void main(String[] args) {

		boolean isPrimeNumber = true;
		for (int i=2 ; i < 50 ; i++) {
			 isPrimeNumber = true;
			for (int j=2;j <i ; j++) {
				if (i%j == 0 ) {
					 isPrimeNumber = false;
					break;
				}
			}
			if (isPrimeNumber)
			System.out.printf("%d ", i);
		}
	}
}
