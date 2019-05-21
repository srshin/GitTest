package com.encore.day11;

public class ThreadTest4 {
	
	public static void call () {
		
		Thread t1 = new PrintThread();
		PrintThread t2 = new PrintThread();
		Runnable r = new PrintThread2();
		Thread t3 = new Thread(r);
		t1.start();
		t2.start();
		t3.start();
	}

	public static void call2 () throws InterruptedException {
		
		int count =0;
		while(true) {
			Thread.sleep(1000);
			count++;
			if(count%3 == 0) {
				Thread t1 = new PrintThread();
				t1.start();
				
			}
		}
		
		
	}
	
	public static void main(String[] args) throws InterruptedException {
		call2();
	}

}
