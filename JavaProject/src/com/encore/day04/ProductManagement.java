package com.encore.day04;

public class ProductManagement {

	public static void main(String[] args) {
		Product product = new Product("Galaxy", "SS", 900000, true);
		Product product2 = new Product("IPHONE", "Apple", 80000, false);
		Product product3 = new Product("Thin", "LG", 400000, true);
		product.productInfo();
		product2.productInfo();
		product3.productInfo();
		
		
		
	}
}
