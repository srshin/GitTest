package com.encore.day08;

public interface Inter2 {
	void print5();
	void print6();
	default void print7() {
		System.out.println("interface2 - print3");
	}
	static void print8() {
		System.out.println("interface2 - print4");
	}
}
