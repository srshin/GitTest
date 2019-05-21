package com.encore.day11;

public class ThreadTest2 {

	public static void main(String[] args) {
	
		Thread t1 = new LowerCaseThread();
		Thread t2 = new LowerCaseThread();
		Thread t3 = new Thread(new NumericThread());
		t1.start();
		t2.start();
		t3.start();
		
		Runnable r = ()->{
			for (int i=1 ; i<=26 ; i++ ) {
				System.out.println("람다식으로 작성 : " + i)	;
				try {
					Thread.sleep((int)(Math.random()*500));
				} catch (InterruptedException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		};
		Thread t4 = new Thread(r); 
		t4.start(); 
		
	}
}
