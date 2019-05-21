package com.encore.day09;

import java.util.Arrays;
import java.util.Objects;

public class CompareTest {
	public static void call() {
		String s1 ="A자바";
		String s2 = "B데이터베이스";
		System.out.println(s1.compareTo(s2));
	}
	public static void call2() {
		//기본형
		int a = 10;
		//참조형
		//Wrapper Class :  저장, 연산 기타등의 기능 제공
		Integer b = 10; 
		Integer c = 20; 
		System.out.println(b.compareTo(c)); 
	}

	public static void call3() {
		Computer[] c = new Computer[4]; 
		c[0] = new Computer("www1", "sam", 1000, null);
		c[1] = new Computer("www3", "sam1", 2000, null);
		c[2] = new Computer("www2", "sam2", 2000, null);
		c[3] = new Computer("www4", "sam3", 2000, null);
		System.out.println(c[1].compareTo(c[0]));
		Arrays.sort(c);
		for (Computer ce : c) {
			System.out.println(ce);
		}
		System.out.println(Objects.compare(c[0], c[1], new ComputerCompare()));
		
	}
	
	public static void main(String[] args) {
		call3(); 
	}
}
