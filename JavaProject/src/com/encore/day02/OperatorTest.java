package com.encore.day02;

public class OperatorTest {

	// 메서드 정의
	public static void method() {
		int a=10 ;
		a++; //1 증가시
		a +=10; //특정 숫자 증가시 a=a+10;
		System.out.println("a="+a);

	}

	// 메서드 정의
	public static void method2() {
		int score =95;
		String grade; 
		//90이상이면 a학점, 그렇지 않으면 b학점
		grade = score > 90 ? "A학점" : "B학점";
		System.out.println(grade);
		
		System.out.println(score > 90 ? "A학점" : "B학점");

		if (score>90) {
			grade = "A학점";
		}else {
			grade = "B학점";
		}
		System.out.println(grade);	
		
		
	}

	// 메서드 정의 .. main은 JVM이 호출한다.
	public static void main(String[] args) {
		System.out.println("--------------------메인 시작");

		// 메서드 호출 : 갔다가 돌아옴.
		method();
		method2();
		System.out.println(10 > 20);
		System.out.println(!(10 > 20));
		System.out.println("------------------------메인 끝");

	}

}
