package com.encore.day10;

import java.util.regex.Pattern;

public class RegExpTest {
	
	
	public static void regTest(String string) {
		
		String regs = "0[01]{2}-[0-9]{4}-[0-9]{4}";
		System.out.println( Pattern.matches(regs, string)? "OK" : "FAIL");
		
	}	
	public static void regTest2(String userId) {
		
		String regs = "[A-Z]\\w+";
		System.out.println( Pattern.matches(regs, userId)? "OK" : "FAIL");
		
	}	
	public static void main(String[] args) {
		regTest("010-9999-9233");
		regTest("110-9999-9233");
		regTest("010-999-0233");
		
		regTest2("Oilksoif90");
		regTest2("Uisjdhs-");
		regTest2("P010-999-0233");
	}
}
