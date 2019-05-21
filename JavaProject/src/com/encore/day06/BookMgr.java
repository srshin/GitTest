package com.encore.day06;


//Business Logic 작성 (service) 

public class BookMgr {

	Book[] booklist;
	BookMgr () {}
	BookMgr(Book[] booklist ) {
		this.booklist = booklist;
	}
	void printBookList() {
		System.out.println("=== 책 목록 ===");
		for (Book bk: booklist) {
			System.out.println(bk.getTitle());
		}
		System.out.println();
	}
	
	void printTotalPrice() {
		System.out.println("=== 책 가격의 총합 ===");
		int total = 0; 
		for (Book bk: booklist) {
			total += bk.getPrice();
		}
		System.out.println("전체 책 가격의 합 : " + total);
		
	}
	
}
