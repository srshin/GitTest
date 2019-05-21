package com.encore.day06;

public class CreditAccount  extends Account {

	int credit; 
	
	public CreditAccount () {}

	public CreditAccount(String accNo, String owner, int balance, int credit) {
		super(accNo, owner, balance);
		this.credit = credit; 
	}
	
	//overriding 
	//접근제한자는 같거나 더 넓어야 한다. 
	public int withdraw(int amount) {
		if ((balance + credit)  < amount)  {
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
	
}
