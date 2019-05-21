package com.encore.day09;

import java.util.Comparator;

public class ComputerCompare implements Comparator<Computer>{

	@Override
	public int compare(Computer o1, Computer o2) {
		return o1.price - o2.price;
	}

}
