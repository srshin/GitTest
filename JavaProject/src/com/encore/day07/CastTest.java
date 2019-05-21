package com.encore.day07;

import com.encore.day06.Account;
import com.encore.day06.CheckingAccount;


public class CastTest {
	public static void infoPrint(Account aa ) {
		System.out.println(aa);
		
		
	}
	public static void main(String[] args) {
		BonusPointAccount acc = new BonusPointAccount("123", "백하연", 100000, 100);
//		System.out.println(acc);
		infoPrint(acc);
		CheckingAccount ca = new CheckingAccount("1332", "위정욱", 20000, "78726");
		//System.out.println(ca);
		infoPrint(ca);
		
		
	}
}
