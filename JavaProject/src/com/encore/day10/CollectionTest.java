package com.encore.day10;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.Vector;

public class CollectionTest {

	public static void call1() {

		Vector data = new Vector();
		data.add(100);
		data.add("자바");
		data.add(new MySum(10, 30));
		int a = (int) data.get(0);
		String b = (String) data.get(1);
		MySum ms = (MySum) data.get(2);
	}

	public static void call2() {
		// Vector: list interface 를 구현 : 순서가 있다. 중복 허용.
		Vector<String> data = new Vector<>();
		data.add("100");
		data.add("100");
		String b = data.get(1);
		System.out.println(b);
	}

	
	public static void print(List<String> day) { //
		// 1. 일반
		for (int i = 0; i < day.size(); i++) 
			System.out.println(day.get(i));

		// 2. 확장
		for (String d : day) 
			System.out.println(d);

		// 3. iterator
		Iterator<String> it = day.iterator();
		while (it.hasNext())	
			System.out.println(it.next());
	}	
	
	public static void getDay(List<String> day) {
		// 중복허용
		day.add("월요일");
		day.add("월요일");
		day.add("화요일");
		day.add("월요일");
		day.add("목요일");
	}
	public static void main(String[] args) {
		List<String> myList = new ArrayList<>();
		getDay(myList);
		print(myList);
		//print(new ArrayList<>());
		//print(new LinkedList<>());
	}
}
