package com.encore.day05;

public class Person {

	private static int numberOfPersons; // 전체 인구 수
	// Person 객체가 생성될 때마다 증가
	int age;
	String name;
	Person(){
		// 나이는 12살, 이름은 “Anonymous”로 초기화함
		this (12, "anonymous");
	}
	Person(int age, String name){
		// 나이는 age 매개변수, 이름은 name 매개변수로 Setting함
		this.age = age; 
		this.name = name; 
		numberOfPersons++;
	}
	
	public void selfIntroduce() // “내 이름은 …. 이며, 나이는 … 살 입니다.”를	출력함
	// 예) 내 이름은 철수이며, 나이는 3살입니다.
	{
		System.out.println("내 이름은 "+ name + " 나이는 " + age + " 살입니다");
		System.out.println(numberOfPersons); // non-static method에서 static field 사용가능 
	}

	static public int getPopulation() // 전체 인구수를 Return함
	{
		return numberOfPersons; 
	}
	
	
}
