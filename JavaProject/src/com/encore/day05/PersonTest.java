package com.encore.day05;

public class PersonTest {
	public static void main(String[] args) {
		
		Person p = new Person();
		Person p2 = new Person(22, "Agahi");
		p.selfIntroduce();
		p2.selfIntroduce();
		System.out.println(Person.getPopulation());

	
	}
}
