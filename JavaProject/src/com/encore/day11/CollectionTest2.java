package com.encore.day11;

import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;
import java.util.Set;

public class CollectionTest2 {
	
	public static void call1() {
		
		Map<Fruit,Student> data = new HashMap(); 
		data.put(new Fruit("사과", 10), new Student("하연", 100));
		data.put(new Fruit("사과", 20), new Student("하연", 500));
		
		System.out.println(data.containsKey(new Fruit("사과", 10)));
		System.out.println(data.get(new Fruit("사과", 550)));
		
		for (Fruit f : data.keySet()) {
			System.out.print(f);
			System.out.print(" ");
			System.out.println(data.get(f));
		}
	}

	public static void call2() {
		Map<String, Fruit> cart = new HashMap<String, Fruit>();
		cart.put("사과", new Fruit("사과", 10));
		cart.put("귤", new Fruit("귤", 20));
		cart.put("바나나", new Fruit("바나나", 20));
		cart.put("오렌지", new Fruit("오렌지", 40));
		cart.put("사과", new Fruit("사과", 30));
		for (String key: cart.keySet()) {
			System.out.print(" key : " + key);
			System.out.print(" value : " + cart.get(key));
		}
		System.out.println();
		
		for (Fruit f: cart.values()) {
			 System.out.print(f);
		}
		System.out.println();
		//entry

		for (Entry <String, Fruit> entry: cart.entrySet()) {
			System.out.print(entry.getKey());
			System.out.println(entry.getValue());
		}
		//key를 이용해서 값을 가져오기 
		Set<String>keys = cart.keySet();
		Iterator<String>it = keys.iterator();
		while (it.hasNext()) {
			String key = it.next();
			System.out.println(cart.get(key));
		}
		
	}

	public static void main(String[] args) {
		call1();
		call2();
	}
}
