package com.encore.day09;

import java.util.Comparator;

public class CoffeeComparator implements Comparator<Coffee>{

	@Override
	public int compare(Coffee c1, Coffee c2) {
		return c1.name2.compareTo(c2.name2);
	}

	
}
