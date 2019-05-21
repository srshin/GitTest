package com.encore.day10;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class StudentController {

	public static void main(String[] args) {
		Scanner sc = new Scanner(System.in);
		List<StudentDTO> data =  new ArrayList<StudentDTO>();
		StudentDAO.init(data);
		
		//1. 입력을 받아라
		System.out.println("1. 모두 조회 2. 입력 9. 끝내기");
		
		//2. 처리를 하라
		while(true) {
			System.out.println("작업을 선택해주세요");
			int menu = sc.nextInt(); 
			if (menu == 9) break; 
			switch (menu) {
			case 1 :
				data = StudentDAO.select(data);
				StudentView.display(data);
				break;
			case 2 :
				System.out.println("이름 점수 >>");
				StudentDTO std = new StudentDTO(sc.next(), sc.nextInt());
				StudentDAO.insert(std, data);
				StudentView.display(data);
			}
		}
		sc.close();
		System.out.println("작업을 종료합니다");
		//3. 출력하라
	}
	
}
