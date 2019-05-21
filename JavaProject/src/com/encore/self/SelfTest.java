package com.encore.self;


class Product {
	int price;
	int bonusPoint;
	Product() {} // 기본생성자
	Product(int price) {
		this.price = price;
		bonusPoint = (int) (price /10.0); // 보너스 점수는 제품가격의 10%
	}
}

class Computer extends Product {
	Computer() { super (200); } // 조상클래스의 생성자를 호출한다
	public String toString () { return "Computer"; }
}

class Audio extends Product {
	Audio() { super (50); } // 조상클래스의 생성자를 호출한다
	public String toString () { return "Audio"; }
}

class TV extends Product {
	TV() { super (100); }
	public String toString () { return "TV"; }
}
class Buyer {
	int money =1000;
	int bonusPoint =0;
	Product [] item = new Product[10];
	int i=0;
	void buy (Product p) {
		if (money < p.price) {
			System.out.println("잔액이 부족하여  물건을 살 수 없습니다");
			return;
		}
		money -= p.price;
		bonusPoint  +=  p.bonusPoint;
		item[i++]= p;
		System.out.println(p + " 구입하셨습니다");
	}
	void summary() {
		int sum=0;
		String itemList ="";
		for (int i=0; i< item.length ; i++) {
			if (item[i] == null ) break;
			sum += item[i].price;
			itemList =itemList + item[i] + " ";
		}
		
		System.out.println("구입한 총금액은 "+ sum + "입니다");			
		System.out.println("구입한 제품은 " + itemList + "입니다");
		System.out.println("현재 남은 돈은 " + money + "만원입니다");
		System.out.println("현재 보너스 점수는 " + bonusPoint + "점입니다");
		}
	}


public class SelfTest {

	public static void main(String[] args) {
		Buyer b = new Buyer();
		
		b.buy(new TV());
		b.buy(new Audio());
		b.buy(new Computer());
		b.summary();
	}
}
