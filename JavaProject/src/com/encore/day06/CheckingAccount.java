package com.encore.day06;

public class CheckingAccount extends Account {

	String cardNo;
	public CheckingAccount () {}

	public CheckingAccount(String accNo, String owner, int balance, String cardNo) {
		super(accNo, owner, balance);
		this.cardNo = cardNo; 
	}
	public int pay(String cardNo, int amount) {
		if (this.cardNo.equals(cardNo) == false) {
			System.out.println("카드 번호 오류 ");
			return 0; 
			
		} else {
			return withdraw(amount);
		}
	}

	
	
	
	
}
