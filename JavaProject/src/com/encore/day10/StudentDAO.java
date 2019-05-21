package com.encore.day10;

import java.util.List;

//DAO : Data Access Object

public class StudentDAO {
	
	public static void init(List<StudentDTO> data) {

		data.add(new StudentDTO("이진주", 100));
		data.add(new StudentDTO("정진", 200));
		data.add(new StudentDTO("이진주1",400));
		data.add(new StudentDTO("이진주2", 300));
		data.add(new StudentDTO("진주3", 200));
		
	}

	public static List<StudentDTO> select(List<StudentDTO> data) {
		//DB연결
		//DB조회
		return data; 
		
	}
	public static void insert(StudentDTO std, List<StudentDTO> data) {
		data.add(std);
	}
	
}
