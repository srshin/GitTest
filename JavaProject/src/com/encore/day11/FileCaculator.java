package com.encore.day11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class FileCaculator {

	public static void main(String[] args) throws IOException {

		BufferedReader br = new BufferedReader(new FileReader("data1.txt"));
		BufferedWriter bw = new BufferedWriter(new FileWriter("data1.txt", true));
		String str;
		int sum = 0; 
		int multiple= 1; 
		
		while ((str = br.readLine()) != null) {
			System.out.println (str);
			//bw.write(str);
			//bw.newLine();
			if (!str.isEmpty()) {
				sum +=Integer.parseInt(str);
				multiple *=Integer.parseInt(str);
			}
		}
		System.out.println(sum);
		bw.newLine();
		bw.write(sum+"");
		bw.newLine();

		System.out.println(multiple);
		bw.write(multiple+"");
		bw.newLine();
		if (br != null) br.close();
		if (bw != null) bw.close();
	}

}
