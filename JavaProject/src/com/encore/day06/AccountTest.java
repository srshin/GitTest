package com.encore.day06;

public class AccountTest {
	public static void main(String[] args) {
		//Account ac = new Account("1929", "정인아", 1000);
		//ac.deposit(2000);
		
		/*CheckingAccount ca = new CheckingAccount("1929", "정인아", 3000, "323");
		ca.pay("323", 1000);
		ca.pay("123", 2000);
		ca.pay("323", 4000);
		*/
		
		CreditAccount ca = new CreditAccount("201-3333", "정인아", 3000, 3000);
		ca.withdraw(4000);
		ca.deposit(3000);
		ca.withdraw(4000);
		ca.withdraw(4000);
		
	}
}
