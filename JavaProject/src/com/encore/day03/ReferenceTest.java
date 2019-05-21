package com.encore.day03;

public class ReferenceTest {

	public static void main(String[] args) {
		int a =10; 
		int b = 10; 
		System.out.println(a==b);
		
		String s1="자바"; //컴파일시 생성 
		String s2="자바"; // s1에서 생성된 스트링 사용하므로 동일한 주소 
		System.out.println(s1==s2); //주소가 같음 
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		
		s1 = s1 + "프로그램" ;
		s2 = s2 + "프로그램" ;
		System.out.println(s1==s2); //주소가 다름 
		System.out.println(System.identityHashCode(s1));
		System.out.println(System.identityHashCode(s2));
		
		System.out.println(s1.equals(s2)); //내용이 같으므로 true
		
		System.out.println(s1);
		System.out.println(s1.toString());
		//-----------------------------------------------------------------
		
		String s3 = new String("자바") ; //run시 생성
		String s4 = new String("자바") ; //run시 생성하므로 주소다름. 
		System.out.println(s3==s4);
		System.out.println(s3.equals(s4));
		System.out.println(System.identityHashCode(s3));
		System.out.println(System.identityHashCode(s4));
		
		//-----------------------------------------------------------------
		String 직책 = "부장";
		int sal = 5000;
		직책  = 직책 + "님"; 
		//if (직책 == "부장님") {
		if ( 직책.equals("부장님")) {
			System.out.println("회사가 어려워요.... 고통분담 "+ sal* 0.9);
		}
		else {
			System.out.println("어렵지만 ..... "+ sal );
		}
		//--------------------------------------------------------------
		String name=null; 
		System.out.println(name);
		//System.out.println(name.length()); //ERROR! null pointer exception (실행시 에러)
		
		
		
		
		
		
		
		
	}
}
