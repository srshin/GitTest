package com.encore.day18_4;

import java.util.ArrayList;
import java.util.List;

public class StdtController {
	//박성철 님 code를 기반으로  수정하였습니다.^^ 
	public static void main(String[] args) {
		StdtDAO dao = new StdtDAO();
		
		//기존 좌석 리스트를 읽어들인다. 
		ArrayList<String> oldSeatList = dao.readSeatList();

		//기존 좌석을 출력한다. 
		StdtView.printList("기존 좌석 ", oldSeatList);

		//학생 데이타를 읽어들인다. 
		List<StdtDTO> dtoList = dao.selectAll(); 


		//학생 데이타를 주고 새로운 좌석리스트를 생성한다.  
		ArrayList<String> newSeatList = dao.makeNewSeatList(dtoList);
		
		//새로운 좌석을 출력한다. 
		StdtView.printList("새로운 좌석 ",newSeatList);
		
	}

}
