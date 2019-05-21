package com.encore.day04;

import java.util.Arrays;

public class 로또생성기 {

	public static void call() {
		//무작위수 만들기
		double rand = Math.random() ; // 0~1사이의 수 0< rand <1)
		System.out.println(rand);
		int num = (int)(rand  *10)+1; //1..10까지의 수 
		System.out.println(num);
		
	}
	public static void call2() {
		int lottoLen = 6;
		int[] lottoArr = new int[lottoLen];
		int count =0; 
		//6개의 무작위수(1<= =<45) 만들기. 중복되서는 안됨. 
		aa:while (true) {
			if (count==lottoLen) break; //반복 빠지기 
			int num = (int)( Math.random() * 45 )+1; //1..45까지의 수 
			//System.out.print(num);
			for (int j=0; j <count ; j++) {
				if (num == lottoArr[j]) {
					System.out.println(" 같은 수 발견! " + num);
					continue aa;
				}
			}
			lottoArr[count]=num;
			System.out.printf("  array[%d] is %d\n", count, lottoArr[count]);
			count++;
		}
		System.out.println(Arrays.toString(lottoArr));
		
	}

	public static void main(String[] args) {
		call2();
	}

}
