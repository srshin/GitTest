package com.encore.day03;

public class ArgsTest {

	public static void main(String[] args) {
//		compute(1,10); //실매개변수
//		int num1=10, num2=100;
//		compute(num1, num2);
//		gcd(7,5);
//		gcd(250,30);
		int result = multiple(10, 5);
		System.out.println(result);
	}

	
	public static int multiple(int num, int num2) {
		
		int sum = 0; 
		for (int i=num2 ; i<=num; i+=num2) {
			sum += i; 
			//System.out.print(i);
		}
		//System.out.println(sum);
		return (sum);
	}
	
	public static void gcd(int num1, int num2) {
		int min = num1> num2? num2 : num1;
		for (int i=min; i>=1; i--) {
			if (num2 % i == 0 && num1 % i == 0) {
				System.out.println(i);
				//break;
			}
		}
		
	}
	public static int compute(int startNum, int endNum) { //형식 매개변수 argument
		int sum = 0 ;
		for (int i=startNum; i<=endNum ; i++) {
			sum += i;
		}
		System.out.printf("%d ~ %d 합계는 %d\n", startNum, endNum, sum);
		return sum;
	}
	
}
