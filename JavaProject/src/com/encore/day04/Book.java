package com.encore.day04;

public class Book {
	//1. field (변수)
	String title; 
	String author;
	int price; 
	
	//2. method (기능)
	Book () {System.out.println("default constructor... Book을 만든다");}
	Book (String _title, String _author, int _price ) {
		this.title = _title;
		this.author = _author;
		this.price = _price; 
	}
	//3. method
	public void showBookInfo() {
		System.out.println("title  "+ title);
		System.out.println("author "+ author);
		System.out.println("price " + price);
		System.out.println();
	}

}
