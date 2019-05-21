package com.encore.day08;

import java.util.Date;
import static java.lang.Math.*;

//java.lang.* 에 있는 모든 클래스들은 자동 import 
//나머지는 import해야 사용할 수 있다. 

public class ImportTest {
	public static void main(String[] args) {
		System.out.println(Math.PI);
		System.out.println(Math.abs(-999));
		System.out.println(Math.max(10, 20));
		System.out.println(PI);
		System.out.println(abs(-999));
		System.out.println(max(10, 20));
		String s = new String("java");
		Date date = new Date();
	}

}
