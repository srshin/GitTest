package com.encore.day04;

public class TestAccount {

	public static void main(String[] args) {
		Account a = new Account("078-3762-293");
		a.save(100000);
		a.deposit(30000);

		System.out.println("계좌번호: \t" + a.getAccNo());
		System.out.println("잔액      : \t" + a.getBalance());
	}

}
