package com.encore.day06;
//6장 클래스와 다형성(Book, BookMgr )
/*Book 클래스의 제약조건
1. 책 제목(title)과 가격(price)정보를 저장하는 멤버변수가 있어야 한다.
2. 멤버변수는 모두 private 접근제한자를 가져야 한다. 
3. 멤버변수를 모두 초기화하는 생성자 메서드가 있어야 한다. 
4. 멤버변수에 값을 설정하고 리턴하는 setter/getter 메서드가 있어야 한다.
setTitle(String title) : 멤버변수 title 값을 셋팅하는 메소드
String getTitle() : 멤버변수 title 값을 반환하는 메소드
    void setPrice(int price) : 멤버변수 price 값을 셋팅하는 메소드
int getPrice() : 멤버변수 price 값을 반환하는 메소드 
5. setter/getter 메서드는 모두 public 접근제한자를 가져야 한다. 

BookMgr 클래스의 제약조건 
1. 책(Book) 객체 여러 개를 저장할 수 있는 책 목록(booklist)이라는 배열을 멤버변수로 가져야 한다. 
2. 책 목록(booklist)이라는 배열 변수를 초기화하는 생성자 메서드를 작성해야 한다. 
3. 책 목록을 화면에 출력하는 printBookList() 메서드가 있어야 한다. 
4. 모든 책 가격의 합을 출력하는 printTotalPrice() 메서드가 있어야 한다. 

[Prob4 실행결과]
=== 책 목록 ===
Java Program
JSP Program
SQL Fundamentals
JDBC Program
EJB Program

=== 책 가격의 총합 ===
전체 책 가격의 합 : 132000
*/

public class BookTest {
	
	public static void call() {
		
		
		System.out.println(Book.PUBLISHER);
		System.out.println(Book.PI);
		//Book.PUBLISHER = "한결"; ERROR! 
		Book b1 = new Book();
		System.out.println(b1.isbn);
		System.out.println(b1.isbn2);
		// b1.isbn = "2342"; ERROR! 

		//Math.PI = 3.14; 
		System.out.println(Math.E);
		System.out.println(Math.max(20,30));
		System.out.println(Integer.parseInt("100")+200);
		System.out.println(Integer.MAX_VALUE);
	}
		
	
	public static void main(String[] args) {
		
		call();
/*		System.out.println("메인에서 count부름 "+ Book.count) ;  //객체 생성없이도 사용 가능 . 메모리에 로딩되어 있기 때문. 		
		Book b1 = new Book();
		Book b3 = new Book("자바의 정석", 30000, "남궁성");
		Book b4 = new Book("이것이 자바다", "남궁성");
		b1.bookInfoPrint();
		b3.bookInfoPrint();
		b4.bookInfoPrint();
*/		
		
		
		/*	    Book[] b = new Book[5];
		b[0] = new Book("Java Program",30000);
		b[1] = new Book("JSP Program",25000);
		b[2] = new Book("SQL Fundamentals",20000);
		b[3] = new Book("JDBC Program",32000);
		b[4] = new Book("EJB Program",25000);
		
		BookMgr bm = new BookMgr(b);
		bm.printBookList();
		bm.printTotalPrice();
*/	}
}

