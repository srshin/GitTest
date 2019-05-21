package com.encore.day11;

class NumericThread  extends Object implements Runnable{
	@Override
	public void run() {
		for (int i =1 ; i <=26 ; i++) {
		    System.out.println(Thread.currentThread().getName()+" :"+ i); //static이니까 가능!
		    try {
				Thread.sleep((int)(Math.random()*500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		System.out.println("숫자출력이 끝남!");
	}
}

class LowerCaseThread  extends Thread{
	@Override
	public void run() {
		for (char i ='a' ; i <='z' ; i++) {
		    System.out.println(Thread.currentThread().getName()+ " :"+  i); //static이니까 가능!
		    try {
				sleep((int)(Math.random()*500));
			} catch (InterruptedException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	    }
		System.out.println("소문자출력이 끝남!");
	}
}


public class ThreadTest {

	public static void main(String[] args) throws InterruptedException {
		//숫자를 출력하는 스레드 (1 ~ 26)
		Runnable r1 = new NumericThread();
		Thread n1 = new Thread(r1); 
		n1.start();//run이 호출된다. 

		Thread n2 = new LowerCaseThread();
		n2.start();//run이 호출된다. 
		
		for (char i ='A' ; i <='Z' ; i++) {
			System.out.println(Thread.currentThread().getName()+ "     :"+ i); //static이니까 가능!
			Thread.sleep((int)(Math.random()*400));
		}
		System.out.println("메인이 끝남!");
	}
}
