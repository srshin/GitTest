package com.encore.day03;

import java.util.Scanner;



public class ArrayTest {

	public static void main(String[] args) {
//		call();
//		call2();
//		call3();
		call4();
		
	}

	public static void call4 () {
		// 시험본 과목의 갯수를 입력하세요. 점수 입력받은 후 총점과 평균을 출력
		Scanner sc = new Scanner(System.in);
		
		
		int[]score = null ;
		int total = 0;
		double avg = 0; 

		System.out.print("시험본 과목의 갯수를 입력하세요 >>>");
		int count = sc.nextInt();
		
		
		//중요 ! 배열 변수가 배열을 가리키도록 할당해줘야 함 !!!
		//
		
		score = new int[count];
		
		for (int i=0; i<count ; i++) {
			System.out.print("점수를 입력하세요>>");
			score[i] = sc.nextInt();
			System.out.println(score[i]+"점이 입력되었습니다. ");
			total += score[i] ;
		}
		avg = (double) total / count;
		System.out.println("총점  :"+total);
		System.out.println("평균  :" +avg);
		sc.close();
	}
	public static void call3 () {
	//사용자에게 친구이름을 입력받자 .. 절친 몇명이야 ? 이름 입력? 내용 출력
		Scanner sc = new Scanner (System.in);
		String[] friend ;
		
		System.out.print("절친 몇명 ? >>");
		int count = sc.nextInt();
		
		friend = new String[count]; // null로 초기화
		System.out.print("친구이름들을 입력하세요>>");
		
		for (int i=0; i < friend.length ; i++) {
			friend[i]=sc.next();
			System.out.println(friend[i]+"님이랑 친하시군요");
		}
		
		sc.close();
	}

	public static void call2 () {
		//int [] score = new int[5];
		int [] score = new int[] {80,90,50,100,70};
//		int [] score =  {89,90,50,100,70};
		int total = 0 ;
		double avg;
		for (int i=0; i < score.length; i++) {
			total += score[i];
		}
		System.out.println(total);
		avg = (double) total / score.length ;
		System.out.println(avg);
	}
	
	
	public static void call() {
		//배열 : 동일한 이름으로 동일한 타입의 여러개의 값을 연속공간에 저장하기 위한 자료 구조
		//1. 배열 선언
		int[] iArr; //더 선호
		char cArr[];
		//2. 배열 생성 (new) .. 자동 초기화
		// 배열 변수에 할당
		iArr = new int[10];
		cArr = new char[5];
		//3. 배열 사용
		//System.out.println(iarr[10]); //error
		for (int i=0; i<iArr.length ; i++) {
			System.out.printf("%d  ", iArr[i]);
		}
		for (int i=0;i<cArr.length; i++) {
			System.out.printf("[%c]  ", cArr[i]);
		}
		//선언과 생성을 동시에
		boolean[] bArr = new boolean[5];
		for (int i=0;i<bArr.length; i++) {
			System.out.printf("[%b]  ", bArr[i]);
		}
		//선언과 생성과 할당 동시에
		String[] message = {"커피", "우유", "쥬스"};
		for (int i=0;i<message.length; i++) {
			System.out.printf("[%s]  ", message[i]);
		}
		
		
		
		
	}

}
