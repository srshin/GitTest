package com.encore.day18_4;

import java.util.HashSet;

class Pair {
	HashSet<String> pairs;

	public Pair(HashSet<String> pairs) {
		super();
		this.pairs = pairs;
	}

	public HashSet<String> getPairs() {
		return pairs;
	}

	public void setPairs(HashSet<String> pairs) {
		this.pairs = pairs;
	}

	@Override
	public String toString() {
		return "[" + pairs + "]";
	}

	@Override
	public int hashCode() {
		final int prime = 31;
		int result = 1;
		result = prime * result + ((pairs == null) ? 0 : pairs.hashCode());
		return result;
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Pair other = (Pair) obj;
		if (pairs == null) {
			if (other.pairs != null)
				return false;
		} else if (!pairs.equals(other.pairs))
			return false;
		return true;
	}

	
	
	
	
}
