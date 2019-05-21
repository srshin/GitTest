package com.encore.day04;

public class Array2DTest {

	public static void main(String[] args) {
		int[] score = { 30,40,60,80,100};
		//일반적인 반복문
		for (int i=0; i < score.length ; i++) {
			System.out.print(score[i]+"\t");
		}
		System.out.println();
		//향상된 반복문
		for (int data:score) { // element type : collection 
			System.out.print(data+"\t");
		}
		System.out.println();
		//2차원
		int[][] score2 = new int[][] { {1,2,3,4,5}, {4,5,6}, {7,8}};
		
		//일반 반복문
		for (int i=0; i < score2.length ; i++) {
			for (int j=0; j < score2[i].length ; j++ ) {
				System.out.print(score2[i][j]+"\t");
			}
			System.out.println();
		}
		
		
	}
}
