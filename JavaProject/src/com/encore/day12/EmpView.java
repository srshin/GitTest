package com.encore.day12;

import java.util.List;

public class EmpView {
	
	public void show (List<EmpDTO> list) {
		//데이타를 출력한다. 
		for (EmpDTO  dto: list) {
			System.out.println(dto);
			//System.out.println(dto.getElement(FIRST_NAME));
		}
		
	}


}
