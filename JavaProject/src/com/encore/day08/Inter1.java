package com.encore.day08;

public interface Inter1 {
	void print();
	void print2();
	default void print3() {
		System.out.println("print3");
	}
	static void print4() {
		System.out.println("print4");
	}
}
