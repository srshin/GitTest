package com.encore.day18_6;

import java.util.Arrays;

class Pair {
	String[] pairs;

	public Pair(String[] pairs) {
		super();
		this.pairs = pairs;
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + Arrays.hashCode(pairs);
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		System.out.println("equal");
		System.out.println(obj.toString());
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (!Arrays.equals(pairs, other.pairs))
			return false;
		return true;
	}

	@Override
	public String toString() {
		return  Arrays.toString(pairs);
	}
	
}
