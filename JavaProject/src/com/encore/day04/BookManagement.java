package com.encore.day04;

public class BookManagement {
	public static void main(String[] args) {
		Book b1 = new Book("자바 프로그램 ", "박정은 ", 300000);
		Book b2 = new Book("파이썬 ", "박하연 ", 20000);
		Book b3 = new Book("하둡 ", "허정표 ", 500000);
		
		
		b1.showBookInfo();
		b2.showBookInfo();
		b3.showBookInfo();
		
		
	}
}
