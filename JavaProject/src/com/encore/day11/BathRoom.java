package com.encore.day11;


//여러개의 흐름이 (thread)가 공유하는 영역(Shared Area)  
public class BathRoom {

	boolean first = true;
	
	synchronized void use(String name) {
		if (first && name.equals("양")) {
			try {
				wait();
			} catch (InterruptedException e) {
				e.printStackTrace();
			}
		}
		first = false; 
		System.out.println(name + "  입장합니다");
		System.out.println(name + "  사용합니다");
		System.out.println(name + "  퇴장합니다");
		System.out.println("--------------------------------");
		notifyAll();
	}
}
