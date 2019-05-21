package com.encore.day04;

public class Product {

	String model;
	String brand; 
	int price; 
	boolean onSale; 
	
	Product () { 
		this(null, null, 0, true);
	}
	Product (String model,  String brand) {
		this(model, brand, 0, true);
	}
	Product (String model) {
		this(model, null, 0, true);
	}
	Product (String model, String brand, int price, boolean onSale) {
		this.model = model; 
		this.brand = brand;
		this.price = price;
		this.onSale = onSale; 
		System.out.println("상품이 생성되었습니다");
	
	}
	public void productInfo() {
		System.out.print("model : " + model);
		System.out.print(" \tbrand : " + brand);
		System.out.print(" \tprice : " + price);
		System.out.print(" \tonSale : " + onSale);
		System.out.println();
	}
}
