package com.encore.self;
/*[클래스 실행결과]
our friends..
-1, 9, false and Sarah Jang
*/
public class DataTypeTest{
private int tom = -1;
	private char marry = '9';
	private boolean john=false;
	private String sarah = "Sarah Jang" ;

	public static void main(String s[]){
		new DataTypeTest().printMyType();
	}
	public void printMyType(){
		System.out.println( "our friends..\n" 
			+ tom + ", " + marry + ", " + john + " and " + sarah);
	}
}


