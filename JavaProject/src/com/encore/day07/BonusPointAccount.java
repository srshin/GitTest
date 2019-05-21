package com.encore.day07;

import com.encore.day06.Account;

public class BonusPointAccount extends Account {

	int bonusPoint; 
	
	BonusPointAccount() {}

	public BonusPointAccount(String accNo, String owner, int balance, int bonusPoint) {
		super(accNo, owner, balance);
		this.bonusPoint = bonusPoint;
	}



	@Override
	public String toString() {
		return "BonusPointAccount 정보 [bonusPoint=" + bonusPoint + ", accNo=" + accNo + ", owner=" + owner + ", balance="
				+ balance + "]";
	}

	@Override
	public void deposit(int amount) {
		balance += amount; 
		bonusPoint +=amount * 0.01; 
		super.deposit(amount); // 부모의 메서드 호출
	}

	@Override
	public void print() {
		System.out.print("Point " + bonusPoint + "  ");
		super.print();
	}
	
	
}
