package com.encore.day06;

public class MyServletTest {

	public static void main(String[] args) {
		MyServlet aa = MyServlet.getInstance();
		MyServlet bb = MyServlet.getInstance();
		System.out.println(aa==bb);
		
	}
}
