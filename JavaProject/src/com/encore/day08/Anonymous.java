package com.encore.day08;

public class Anonymous {
	
	public static void work(MyInterface aa) {
		aa.print();
	}

		
	public static void main(String[] args) {
		work(new MyInterImple());
		work(new MyInterImple2());
		work(new MyInterface() {
			void call() {
				System.out.println("추가된 함수: 익명클래스 내에서 사용하기 위해서 정의된 함수 ");
			}
			@Override
			public void print() {
				System.out.println("익명 클래스");
				call();
			}
		});
	
	}
}