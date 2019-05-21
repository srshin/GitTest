package com.encore.day18_5;


import java.util.List;

public class StdtView {
	public static void printList(String message, List<String> stdlist){
		
		String[] arr = stdlist.toArray(new String[stdlist.size()]);
		
		System.out.printf("==============================   %s  ======================================%n", message);
		System.out.printf("| %s | %s | %s | %s | \t | %s | %s | %s | %s |%n",
									"ㅇㅇㅇ", arr[0], arr[1], arr[2], arr[3], arr[4], arr[5], "ㅇㅇㅇ");
		System.out.printf("==============================================================================%n");
		System.out.printf("| %s | %s | %s | %s | \t | %s | %s | %s | %s |%n",
									arr[6], arr[7], arr[8], arr[9], arr[10], arr[11], arr[12], "ㅇㅇㅇ");
		System.out.printf("==============================================================================%n");
		System.out.printf("| %s | %s | %s | %s | \t | %s | %s |%n",
									arr[13], arr[14], arr[15], arr[16], arr[17], arr[18]);
		System.out.printf("==============================================================================%n");
		System.out.printf("\t      | %s | %s | \t | %s | %s |%n",
									arr[19], arr[20], arr[21], arr[22]);
		System.out.printf("==============================================================================%n");
		System.out.printf("\t      | %s | %s | \t | %s | %s |%n",
									"ㅇㅇㅇ", "ㅇㅇㅇ", "ㅇㅇㅇ", "ㅇㅇㅇ");
		System.out.println();
		System.out.println();
	}
}
