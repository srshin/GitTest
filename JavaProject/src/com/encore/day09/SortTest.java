package com.encore.day09;

import java.util.Arrays;


public class SortTest {
	public static void call() {
		int[] arr = {1,3,5,12,4,6,3,5,22};
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
	}
	public static void call2() {
		String[] arr = {"Java","Python","JavaScript","Hadoop","하이브"};
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr, new DescendingSortString());
		System.out.println(Arrays.toString(arr));
	}

	public static void call3() {
		Coffee[] arr = {new Coffee("아메리카노", 2000, 'L'),new Coffee("카푸치노", 1000, 'L'),new Coffee("카페라떼", 3000, 'L')}; 
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr, new CoffeeComparator() );
		System.out.println(Arrays.toString(arr));
	}
	public static void main(String[] args) {
		call3();
		
	}
}
