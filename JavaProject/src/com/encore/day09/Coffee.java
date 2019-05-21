package com.encore.day09;

public class Coffee implements Cloneable, Comparable<Coffee> {
	String name2;
	int price;
	char size2;
	
	@Override
	protected Object clone() throws CloneNotSupportedException {
		// TODO Auto-generated method stub
		return super.clone();
	}

	public Coffee(String name, int price, char size) {
		super();
		this.name2 = name;
		this.price = price;
		this.size2 = size;
	}

	public String getName() {
		return name2;
	}

	public void setName(String name) {
		this.name2 = name;
	}

	public int getPrice() {
		return price;
	}

	public void setPrice(int price) {
		this.price = price;
	}

	public char getSize() {
		return size2;
	}

	public void setSize(char size) {
		this.size2 = size;
	}

	@Override
	public String toString() {
		return "Coffee [name=" + name2 + ", price=" + price + ", size=" + size2 + "]";
	}

	@Override
	public int hashCode() {
		// TODO Auto-generated method stub
		return super.hashCode();
	}

	@Override
	public boolean equals(Object obj) {
		// TODO Auto-generated method stub
		return super.equals(obj);
	}

	@Override
	public int compareTo(Coffee coffee) {
		int result = size2 - coffee.size2;
		if (result == 0 ) 
			return price - coffee.price;
		return 	result; 
	}
	
}
