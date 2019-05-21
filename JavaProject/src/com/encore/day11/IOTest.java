package com.encore.day11;

import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

public class IOTest {

	public static void call() throws IOException {
		InputStream is = System.in;
		InputStreamReader ir = new InputStreamReader(is);
		int i;
		
		while((i= ir.read())!=13) 
			System.out.print((char)i);
		
		
	}
	public static void main(String[] args) throws IOException {
		call();
	}
}
