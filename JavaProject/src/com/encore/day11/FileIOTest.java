package com.encore.day11;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

import com.encore.day07.Directory;

public class FileIOTest {

	
	public static void call() {
		File f = new File("src/com/encore/day11/Account.java");
		System.out.println(f.exists());
		System.out.println(f.length());
		System.out.println(f.getAbsolutePath());
		Directory d = new Directory(null);
	
	}
	
	
	public static void call2() {
		FileInputStream f1 = null; 
		FileOutputStream f2 = null; 
		try {
			 f1 = new FileInputStream("src/com/encore/day11/sensitive.jpg");
			 f2 = new FileOutputStream("src/com/encore/day11/sensitive2.jpg");
			 int i=0; 
			 while( (i = f1.read())!= -1 ) {
				 f2.write(i);
			 }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			
			try {
				if (f1!=null) f1.close();
				if (f2!=null) f2.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	
	public static void call3() {
		FileReader fr = null;
		FileWriter fw = null; 
		try {
			 fr = new FileReader("src/com/encore/day11/Account.java");
			 fw = new FileWriter("Account2.java");
			 int i;
			 while ( (i=fr.read()) !=-1) {
				 fw.write(i);
				 System.out.print((char)i);
			 }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally  {
			try {
				if(fr!=null) fr.close();
				if(fw!=null) fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	public static void call4() {
		FileReader fr = null;
		FileWriter fw = null; 
		BufferedReader br = null; 
		BufferedWriter bw = null; 
		try {
			 fr = new FileReader("src/com/encore/day11/Account.java");
			 fw = new FileWriter("Account3.java");
			 br = new BufferedReader(fr);
			 bw = new BufferedWriter(fw);
			 
			 int i;
			 while ( (i=br.read()) !=-1) {
				 bw.write(i);
				 System.out.print((char)i);
			 }
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally  {
			try {
				if(fr!=null) fr.close();
				if(fw!=null) fw.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}

	
		public static void main(String[] args) {
		call4();
		System.out.println(System.getProperty("user.dir"));
	}
}
