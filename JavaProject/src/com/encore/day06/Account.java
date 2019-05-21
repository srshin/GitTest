package com.encore.day06;


//final : 변수에 있으면 값 변경 불가 
//final : class에 있으면 상속 불가
//final : method에 있으면 재 정의 불가 
public class Account { 
	protected String accNo;
	protected String owner; 
	protected int balance; 
	
	public Account () {}

	public Account(String accNo, String owner, int balance) {
		super();
		this.accNo = accNo;
		this.owner = owner;
		this.balance = balance;
		//print();
	}
	public void deposit(int amount) {
		balance += amount; 
		System.out.print(amount + "가 입금됩니다  ");
		print();
	}
	protected int withdraw(int amount) {
		if (balance < amount)  {
			System.out.print("잔고가 부족합니다  " + amount + "는 출금되지 않습니다"); 
			print(); 
			return 0;
		}
		else {
			balance-=amount; 
			System.out.print(amount + "이 출금됩니다  ");
			print(); 
			return amount; 
		}
	}

	public void print () {
		System.out.printf("\t\t잔액: %5d\n",  balance);
	}
	
	
	
}
