package com.encore.day09;

import java.util.Objects;

public class CoffeeTest {

	public static void main(String[] args) {
		Coffee c1 = new Coffee("카페라떼", 3000, 'S');
		Coffee c2 = new Coffee("카페", 3000, 'S');
		
		int ret = c1.compareTo(c2);
		System.out.println(ret);
		
		ret = Objects.compare(c1, c2, new CoffeeComparator());
		System.out.println(ret);
		
	}
}
