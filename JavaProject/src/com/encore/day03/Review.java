package com.encore.day03;




public class Review {
	public static void call3() {
		int num = 5;
		for (int i = 1 ; i <=num ; i++ ) {
			for (int j =1 ; j <=i ; j++) {
				System.out.print("*");
			}
			System.out.println();
		}
	}

	public static void call2() {
		for (int i = 1 ; i <=10 ; i++ ) {
			if ( i == 4 ) continue;
			System.out.println(i);
		}
	}	
	
	
	public static void factorial () {
		int number = 5;
		for (int j=number; j >=1; j--) {
			System.out.printf("%d! = ", j);
			int result = 1; 
			for (int i=j; i >=1 ; i--) {
				result *=i;
				System.out.printf("%d ", i);
				if (i == 1) System.out.printf(" = ");
				else System.out.printf( " * " );
			}
			System.out.printf("%d\n",  result);
		}
	}
	public static void call() {
		int sum = 0;
		int count = 0;
		System.out.printf("%s\n", "7의 배수 갯수와 합");
		for (int i=7; i<=100; i+=7) {
			sum +=i;
			count++;
			System.out.printf("%d\n", i);
			
		}
		System.out.printf("sum=%d count=%d", sum, count);
	}
	public static void main(String[] args) {
//		factorial(); 
//		call2();
		call3();
	}
}
