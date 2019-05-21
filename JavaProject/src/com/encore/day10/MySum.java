package com.encore.day10;

public class MySum implements Cloneable, Comparable<MySum> {
	int first; 
	int second;
	public MySum(int first, int second) {
		super();
		this.first = first;
		this.second = second;
	}
	@Override
	public String toString() {
//		return first+second+ "";
		return String.valueOf(first + second);
	}

	@Override
	public boolean equals(Object obj) {
		MySum my = (MySum)obj;
//		return  (first+second ==my.first + my.second );
		return toString().equals(my.toString());
	}
	@Override
	protected Object clone() throws CloneNotSupportedException {
		return super.clone();
	}
	@Override
	public int compareTo(MySum mySum) {
		
		return (first + second) - (mySum.first + mySum.second);
	}
	
	
	
	
}
