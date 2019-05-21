package com.encore.day10;

import java.util.List;

//출력
public class StudentView {

	public static void display(List<StudentDTO> data) {
		System.out.println("-----------학생정보입니다---------");
		for (StudentDTO student : data) 
			System.out.println(student);
	}
}
