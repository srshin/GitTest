package com.encore.day03;

// 2018년 10월 24일 
// 수열문제
//
//• 수열 규칙 : 1부터 시작해서 두 항의 차이가 1씩 증가
//• 예 시 : 1 + 2 + 4 + 7 + 11 + 16 + 22 + …………
// 위 수열에서 15번째 항까지의 합을 구하는 프로그램을 작성
// 출력값
// 15번째까지의 합 : 575

public class 신상림 {

	public static void main(String[] args) {

		int j=1;
		int sum=0;
		for (int i=0; i<15; i++) {
			j=j+i;
			sum +=j;
			//System.out.print(j+ " ");
		}
		
		System.out.println(sum); 
	}

}
