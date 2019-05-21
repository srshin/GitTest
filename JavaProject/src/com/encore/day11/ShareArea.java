package com.encore.day11;

public class ShareArea {

	Account lee;
	Account sung;

	public ShareArea(Account lee, Account sung) {
		super();
		this.lee = lee;
		this.sung = sung;
	}

	void transfer() {
		synchronized (this) 
		{
			int amount = lee.withdraw(100);
			//System.out.println(amount + "이몽룡에게서 출금 ");
			sung.deposit(amount);
			//System.out.println(amount + "성춘향에게 입금 ");
			System.out.println("***********************");
		}
	}
	
	synchronized void print( ) {
		System.out.print ("잔고는  ");
		int total = lee.balance + sung.balance;
		System.out.println(total + "입니다");
	}
		
}
	

