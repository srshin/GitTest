package com.encore.day11;

public class AccountThreadTest {

	public static void main(String[] args) {
		
	
	Account acc1 = new Account("222", "Lee", 2000);
	Account acc2 = new Account("333", "Sung", 1000);
	ShareArea share = new ShareArea(acc1, acc2);
	
	Thread t1 = new TransferThread(share);
	Thread t2 = new PrintBalanceThread(share);
	
	t1.start(); 
	t2.start();
	}
}