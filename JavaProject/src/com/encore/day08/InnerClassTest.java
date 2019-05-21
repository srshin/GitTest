package com.encore.day08;

import com.encore.day08.OuterClass.InnerClassA;
import com.encore.day08.OuterClass.InnerClassB;

class OuterClass {
	
	int a = 10;
	static int b = 20;
	
	//instance class
	class InnerClassA {
		int c =30;
		//static int d = 40;  ERROR! : instance class안에 static 선언 불가
	}
	static class InnerClassB {
		int e = 40;
		static int f = 90;
	}
	
	public void print() {
		int efg=70; //지역 변수 
		
		//local class
		class InnerClassC {
			
		}
	}
}


public class InnerClassTest {
	public static void main(String[] args) {
		OuterClass o = new OuterClass();
		System.out.println(o.a);
		//instance inner class 사용법 
		//InnerClassA aa = new InnerClassA(); ERROR! 
		
		InnerClassA a = new OuterClass().new InnerClassA();
		System.out.println(a.c);
		InnerClassB b = new InnerClassB();
		System.out.println(b.e);
		System.out.println(InnerClassB.f);
	
		
		
	}
	
}
