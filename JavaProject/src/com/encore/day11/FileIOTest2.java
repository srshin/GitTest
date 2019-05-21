package com.encore.day11;
import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class FileIOTest2 {

	public static void main(String[] args) throws IOException {
		BufferedReader br = null; 
		br = new BufferedReader(new FileReader("data.txt"));
		
		String str;
		str = br.readLine(); //title 
		System.out.print(str.replace("/", "\t"));
		System.out.println("\t총점\t평균");
		while ((str = br.readLine()) != null ) {
			String[] data = str.split("/");
			System.out.print(data[0]);
			int total = 0; 
			for (int i=1; i <data.length; i++) {
				total += Integer.parseInt(data[i]);
				System.out.print("\t" + data[i]);
			}
			System.out.print("\t"+ total);
			System.out.println("\t"+ total/3);
		}
		if (br!=null) br.close();
	}
}
