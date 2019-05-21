package com.encore.day04;

public class CellPhone {

	String model;
	String color;
	double size;
	int price;
	char os;
	

	public CellPhone(String model) {
		this (model, "Black", 5.6, 100000, 'A');
	}
	

	public CellPhone(String model, String color) {
		this (model, color, 5.6, 100000, 'A');
	}
	
	public CellPhone(String model, String color, double size) {
		this (model, color, size, 100000, 'A');
	}
	
	public CellPhone(String model, String color, double size, int price) {
		this (model, color, size, price, 'A');
	}

	public CellPhone(String model, String color, double size, int price, char os) {
		this.model = model;
		this.color = color;
		this.size = size;
		this.price = price;
		this.os = os;
	}
	
	
	public void print() {
		
		System.out.println("model " +  model);
		System.out.println("\tcolor " +  color);
		System.out.println("\tsize " +  size);
		System.out.println("\tprice " +  price);
		System.out.println("\tO/S " +  os);
		
		
		
	}
	
	
}
