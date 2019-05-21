package com.encore.day11;

public class BathThreadTest {
	public static void main(String[] args) {
		BathRoom room = new BathRoom();
		BathTread t1 = new BathTread("양", room);
		BathTread t2 = new BathTread("김", room);
		BathTread t3 = new BathTread("박", room);
		BathTread t4 = new BathTread("이", room);
		t1.start();
		t2.start();
		t3.start();
		t4.start(); 
		
		
		
	}
}
