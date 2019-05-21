package com.encore.day10;

public class BoxTest {
	
	
	
	
	
	public static void call() {
		Box<Integer, String, String> box = new Box<>(10, "나무", "Green");
		//Box<Integer> box = new Box<Integer>("sjj", "나무", "Green"); ERROR 컴파일시 에러 체크 !!!!
		System.out.println(box);
		
		Box<String, String, String> box2 = new Box<>("중", "종이", "white");
		System.out.println(box2);
		
		Box<MySum, String, String>box3 = new Box<>(new MySum(10,20), "철", "red");
		System.out.println(box3);
		
		Box<Integer, Integer, Integer>b4= new Box(1,2,3);
		System.out.println(b4);
		
	}
	public static void main(String[] args) {
		call(); 
	}
}
