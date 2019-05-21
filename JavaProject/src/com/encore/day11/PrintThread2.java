package com.encore.day11;

public class PrintThread2 implements Runnable {

	@Override
	public void run() {
		int total=0; 
		for (int i = 1; i <= 10; i++) {
			System.out.println(Thread.currentThread().getName() + i);
			total +=i; 
			try {
				Thread.sleep(1000);
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
		System.out.println(Thread.currentThread().getName() + "total" + total);

	}

}
