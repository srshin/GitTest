package com.encore.day09;

public class CloneTest {

	
	public static void main(String[] args) throws CloneNotSupportedException {
		Computer com = new Computer("sdsd", "samsung", 2000, new String[] {"window10", "16G", "2000G"});
		Computer com2 = (Computer) com.clone();
		System.out.println(com);
		System.out.println(com2);
		com.spec[1] = "32G";
		System.out.println(com);
		System.out.println(com2);
		com2 = null;
		com = null; 
	}
}
