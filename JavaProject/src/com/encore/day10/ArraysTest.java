package com.encore.day10;

import java.text.SimpleDateFormat;
import java.util.Arrays;
import java.util.Calendar;
import java.util.Date;
import java.util.Random;

import util.DateUtil;

public class ArraysTest {

	public static void test1() {
		
		int[] arr = new int[10];
		Arrays.fill(arr, 100);
		System.out.println(Arrays.toString(arr));
	}
	
	public static void test2() {
		
		int a =10; 
		Integer b =20; //new Integer(20) => auto Boxing
		Integer c = new Integer(10); 
		System.out.println(b);
		System.out.println(c);
		System.out.println(b.intValue());
		System.out.println(Integer.toBinaryString(a));
		Integer.toBinaryString(b);
		int d=Integer.parseInt(Integer.toString(a)) +10 ;
		System.out.println(d);
		
		Random r = new Random();
		int num = r.nextInt(45) +1 ;
		System.out.println(num);
		
	}
	
	public static void test3() {
		
		Date d = new Date(); 
		System.out.println(d);
		System.out.println(d.getYear()+1900 + "년도");
		System.out.println(d.getMonth()+1  + "월");
		
		Date d2 = new Date(2005,8,31);
		System.out.println(DateUtil.dateToString(d2));
		System.out.println(DateUtil.dateToString(new Date()));
		
	}
	public static void test4() {
		Calendar ca = Calendar.getInstance();
		System.out.println(ca);
		
		System.out.println(ca.get(Calendar.YEAR) + "년");
		System.out.println(ca.get(Calendar.MONTH) + "월");
	
		ca.set(2005, 8, 31);

		System.out.println(ca.get(Calendar.YEAR) + "년");
		System.out.println(ca.get(Calendar.MONTH) + "월");
	
	}
	public static void main(String[] args) {
		test4();
	}
}
