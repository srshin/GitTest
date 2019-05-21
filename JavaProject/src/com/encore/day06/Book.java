package com.encore.day06;

// JavaBeans기술에서 이용한다. 
// DTO (Data Transfer Object )
// VO  (Value Object) - data를 담기위한 가방 (틀)

public class Book {
	
	//1. 멤버 변수 (field) .. data를 저장 
	public String title; // 다른 패키지에서 접근 가능 
	private int price;  // 이 클래스내에서만 접근 가능 (정보 은닉, 캡슐화)
	String author; // 같은 패키지에서 접근 가능 (default)
	
	//final 마지막 - 한번만 할당이 가능. 선언시 생성시 할당.  변경 불가능. 
	public final String isbn="12345667";
	public final String isbn2 ;
	
	public static final String PUBLISHER = "위키"; //상수. 반드시 선언시 할당. 변경 불가능. 
	public static final double PI = 3.141592; //대문자로 정의 
	
	public void finalTest() {
		//isbn="sldkf"; ERROR! final cannot be modified!!!
	}
	
	static int count;//static은 class 변수이므로 모든 object가 공유.
	
	static int getCount() {
		return count;
	}
	//5. static block : logic이 필요한 초기화 !
	static
	{
		System.out.println("클래스 로드시 1번 실행"+ count);
	}
	//instance block 
	{
		this.isbn2 = "13948";  //생성시 할당
		count++; 
		System.out.println("객체가 생성될 때마다 수행된다. " + count);
	}
	// 생성자  --- 초기화 목적 default 생성자는 제공됨. 
	Book () { System.out.println("default 생성자");}
	Book (String title, int price, String author) {
		this.title = title ; 
		this.price = price ; 
		this.author = author ; 
	}
	public Book(String title, String author) {
		this (title, 0, author);		
		}
	
	//매서드
	//반드시 return값에 대한 정의 필요함!
	public void bookInfoPrint() {
		System.out.print("책 제목 " + title);
		System.out.print("  가격" + price);
		System.out.println("  작가 " + author);
		
	}
	
	public void setTitle (String title) {
		this.title = title; 
	}
	public void setPrice (int price ) {
		this.price = price;
	}
	public String getTitle () {
		return this.title;
	}
	public int getPrice() {
		return this.price;
	}
}
