package com.encore.day06;

public class MyServlet {
	
	private static MyServlet my; 
	private MyServlet() { //private : 외부에서 생성못하게 해야 함. 외부에서 접근 불가 !!
	}
	//따라서 외부에서 접근할 수 있는 메서드를 제공해야 함. 
	public static MyServlet getInstance() { //object를 생성해서 return해야 하므로 return  값은 object이어야 함. 
		//instance생성 전에 불러야 하므로 static 
		if (my == null ) my = new MyServlet();
		return my; 
		
	}
	
	
	
}
