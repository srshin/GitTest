package com.encore.day01;

public class Operator {
	
	public static void test() {
		{
			int a = 10;
			int b = 20;
			boolean result = a==10 && ++b ==20;
			System.out.println("b="+b);
		}
		{
			int a = 10;
			int b = 20;
			boolean result = a!=10 && ++b ==20;
			System.out.println("b="+b);
		}
	}
	
	
	public static void main(String[] args) {
		{
		//단항연산자
		int i = 100;
		i++;
		i++;
		System.out.println("i="+i);
		i--;
		i--;
		System.out.println("i="+i);
		int i2=200;
		int result = ++i + ++i2;
		System.out.println("result="+result);
		result = i++ + i2++;
		System.out.println("result="+result);
		}
		{
			//이항연산자
			int c = 100;
			int d = 3;
			System.out.println("더하기"+ c+d);//"더하기" +"100" + "3"이 됨 !
			System.out.println("더하기"+ (c+d));//"더하기" +"103" 이 됨 !
			// System.out.println("빼기" + c-d); Error! 
			System.out.println(c*d);
			//비교연산자, 관계연산자
			System.out.println(c>d);
			System.out.println(c=d);
			//논리연산자 && || !(not)
			System.out.println(!(c>d));
			System.out.println(!(c<=d));
			
			String subject = null; //값이 정의되지 않았다
			//System.out.println(subject == null && subject.length() > 10 ); ERROR !
			System.out.println(subject != null && subject.length() > 10 ); //단축구문 ERROR아님:뒷문장수행안되므로 
			//System.out.println(subject != null & subject.length() > 10 ); ERROR! 
			System.out.println(subject == null || subject.length() > 10 ); //단축구문 ERROR아님:뒷문장수행안됨. 
			//System.out.println(subject == null | subject.length() > 10 ); ERROR ! 
			
			
		}
		test();
	}
}
