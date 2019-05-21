package com.encore.day11;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.TreeSet;

public class CollectionTest {
	public static void call() {
		List<String> data = new ArrayList<>();
		data.add("월요일");
		data.add("화요일");
		data.add("수요일");
		data.add("목요일");
		data.add("금요일");
		data.add("토요일"); // 중복 허용
		data.add("토요일");
		for (String s : data) {
			System.out.println(s);
		}
	}

	public static void call2() {
		Set<String> data = new HashSet<>(); // 순서 변경 중복안됨
		data.add("월요일");
		data.add("화요일");
		data.add("수요일");
		data.add("목요일");
		data.add("금요일");
		data.add("토요일"); // 중복 허용
		data.add("토요일");
		for (String s : data) {
			System.out.print(s + " ");
		}
		Iterator<String> it = data.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}

	public static void call3() {
		Set<String> data = new TreeSet<>(); // Sorting됨!
		data.add("월요일");
		data.add("화요일");
		data.add("수요일");
		data.add("목요일");
		data.add("금요일");
		data.add("토요일"); // 중복 허용
		data.add("토요일");
		for (String s : data) {
			System.out.print(s + " ");
		}
		Iterator<String> it = data.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}

	public static void call4() {
		Set<Student> data = new HashSet<>(); // 순서 변경 중복안됨
		data.add(new Student("월요일", 100)); // equals()와 hashcode를 override해줘야 함!
		data.add(new Student("월요일", 100));
		data.add(new Student("월요일", 100));
		data.add(new Student("월요일", 100));
		data.add(new Student("월요일", 100));
		data.add(new Student("월요일", 100));
		data.add(new Student("월요일", 100));
		data.add(new Student("월요일", 100));
		data.add(new Student("월요일", 100));
		data.add(new Student("월요일", 100));
		for (Student s : data) {
			System.out.print(s + " ");
		}
		System.out.println();
		Iterator<Student> it = data.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
		
		System.out.println(data.contains(new Student("월요일", 200)));
	}

	public static void call5() {
		Set<Student> data = new TreeSet<>(); // 순서 변경 중복안됨
		data.add(new Student("월요일", 100)); // 
		data.add(new Student("월요일", 100));
		data.add(new Student("월요일", 100));
		data.add(new Student("월요일", 70));
		data.add(new Student("월요일", 80));
		data.add(new Student("월요일", 100));
		data.add(new Student("금요일", 100));
		data.add(new Student("월요일", 100));
		data.add(new Student("월요일", 100));
		data.add(new Student("월요일", 100));
		for (Student s : data) {
			System.out.print(s + " ");
		}
		System.out.println();
		Iterator<Student> it = data.iterator();
		while (it.hasNext()) {
			System.out.print(it.next() + " ");
		}
	}

	public static void main(String[] args) {
		call4();
	}
}
