package com.encore.day04;

public class Array2D {

	public static void main(String[] args) {
		//배열 선언 방법
		int[] iarr;
		int iarr2[];
		int[] iarr3 = new int[10];
		int[] iarr4 = new int[] {10, 20, 30};
		int[] iarr5 =  {10, 20, 30};
		//2차원 배열은 배열의 배열
		int[][] arr;
		int[] arr2[];
		int arr3[][];
		arr = new int[3][4];
		arr2 = new int[23][];
		//arr3 = new int[][]; ERROR!
		arr3 = new int[9][5];
		System.out.println(arr.length);
		System.out.println(arr[0].length);
		
		System.out.println(arr2.length);
		System.out.println(arr3.length);

		//System.out.println(arr2[0].length); //run time ERROR! 
		arr2[0] = new int[23];
		System.out.println(arr2[0].length);
		
		arr[0][0]=90; 
		arr[1][0]=90; 
		
		for (int row=0 ; row<arr.length ; row++) {
			System.out.print(row+ "행 : ");
			for (int column =0; column <arr[row].length; column++) {
				System.out.print(column + "열   " + arr[row][column]+ "  ");
			}
			System.out.println();
		}

	}

}
