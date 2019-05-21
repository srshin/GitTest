package com.encore.day05;

public class StaffTest {
	public static void main(String[] args) {
	
		Staff[] staffArray = new Staff[4];
		staffArray[0] = new Staff("이부장", "부장", 1500000);
		staffArray[1] = new Staff("김과장", "과장", 1300000);
		staffArray[2] = new Staff("최대리", "대리", 1200000);
		staffArray[3] = new Staff("박사원", "사원", 1000000);
		
		for (Staff s: staffArray) {
			s.print();
		}
	}
}
