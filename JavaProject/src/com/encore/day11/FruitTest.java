package com.encore.day11;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class FruitTest {

	public static void call2() {
		// 키 중복 불가 , 나중것이 유효
		Map<String, Integer> students = new HashMap<>();
		students.put("월", 100);
		students.put("월", 100);
		students.put("춘심", 300);
		students.put("목단", 200);
		students.put("월", 100);
		students.put("월", 40);
		students.put("월", 500);

		for (String key : students.keySet()) {
			System.out.print(key);
			System.out.println(students.get(key));
		}

	}

	public static void call() {
		Set<Fruit> cart = new HashSet<>();
		cart.add(new Fruit("사과", 10));
		cart.add(new Fruit("귤", 20));
		Fruit f = new Fruit("사과", 30);
		System.out.println(cart.contains(f));
	}

	public static void call3() {
		Map<String, Fruit> cart = new HashMap<>();
		cart.put("사과", new Fruit("사과", 10));
		cart.put("귤", new Fruit("귤", 20));
		cart.put("감", new Fruit("감", 10));
		Fruit newFruit = new Fruit("사과", 30);
		if (cart.containsKey(newFruit.name)) {
			Fruit f = cart.get(newFruit.name);
			f.count += newFruit.count;
		} else {
			cart.put(newFruit.name, newFruit);
		}

		for (String key : cart.keySet()) {
			System.out.print(key);
			System.out.println(cart.get(key));
		}

	}


	public static void main(String[] args) {
		call3();
	}
}
