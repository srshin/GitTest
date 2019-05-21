package com.encore.day04;

public class Account {
	String accNo;
	int balance;
	Account () {}
	Account (String accNo) {
		this.accNo =accNo;
		System.out.println("계좌가 개설되었습니다.");
		print();
	}
	void save(int money) {
		this.balance += money;
		System.out.println("계좌에 "+ money/1000 + "만원이 입금되었습니다");
		print(); 
	}

	void deposit(int money) {
		this.balance -= money; 
		System.out.println("계좌에 "+ money/1000 + "만원이 출금되었습니다");
		print(); 
		
	}
	void print() {
		System.out.println("계좌의 잔고가 "+balance/1000 +"만원 입니다");
		
	}
	String getAccNo() {
		return accNo;
	}
	int getBalance() {
		return balance; 
	}
}
