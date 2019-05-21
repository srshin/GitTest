package com.encore.day11;

public class LamdaTest {
	public static void call(MyInterface my) {
		my.print();
		
		
	}
	public static void main(String[] args) {
		call(new MyClass());
		call(new MyClass2());
		
		MyInterface aa = new MyInterface() {

			@Override
			public void print() {
				System.out.println("익명재정의");
			}
			
		};
		call(aa);
		call(aa);
		call(
				new MyInterface() {

					@Override
					public void print() {
						System.out.println("익명재정의");
					}
				}				
				
				);
		
		MyInterface bb = () -> {System.out.println("람다식 표현 ");};
		call(bb);
		call(() -> {System.out.println("람다식 표현 ");}); 

		MyInter cc = (a)-> a+20;
		int res = cc.sum(100);
		System.out.println(res);
		
		TV tv = (ch)->{System.out.println(ch + "전원을 켠다"); };
		tv.turnOn(9); 
		
	}
}

interface TV {
	void turnOn(int channel); 
}
interface MyInter {
	int sum(int a);
}
