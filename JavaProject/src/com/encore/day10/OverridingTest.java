package com.encore.day10;

import java.util.Arrays;

public class OverridingTest {
	
	public static void call1() throws CloneNotSupportedException {
		int i=10;
		int j=20;
		MySum ms1= new MySum(i,j);
		MySum ms2= new MySum(i,j);
		
		
		//복제가 아님! 
		MySum ms3 = ms2;  
		ms3.first = 100;
		System.out.println(ms3);
		System.out.println(ms2);
		
		
		//복제는 clone()!  강제형변환 필요함 !
		MySum ms4 = (MySum) ms1.clone(); 
		System.out.println("-----------------");
		ms4.first =14; 
		System.out.println(ms4);
		System.out.println(ms1);
		System.out.println("-----------------");
		
		
		
		System.out.println(ms1); // ms1.toString이 호출됨. 
		System.out.println(ms2); // ms2.toString이 호출됨. 
		
		if (ms1.equals(ms2)) {
			System.out.println("ms1과 ms2의 합계는 동일합니다");
			
		}else {
			System.out.println("ms1과 ms2의 합계는 동일하지 않습니다");
			
		}
		
		

		
	}
	public static void call2 () {
	
		int[] arr= {3,20,40,29,3,42,544,39,85};
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		
	}
	
	public static void call3 () {
		
		MySum[] arr= {new MySum(10,20), new MySum(130,20), new MySum(10,235), new MySum(10,25), new MySum(10,30)};
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr);
		System.out.println(Arrays.toString(arr));
		Arrays.sort(arr, new DescendingMySum());
		System.out.println(Arrays.toString(arr));
	}
	
	public static void main(String[] args) throws CloneNotSupportedException {
		call3(); 
		
	}
}
