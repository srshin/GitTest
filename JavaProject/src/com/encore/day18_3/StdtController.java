package com.encore.day18_3;

public class StdtController {
	//박성철 님 code를 기반으로  수정하였습니다.^^ 
	
	public static void main(String[] args) {
		
		StdtDAO dao = new StdtDAO();
		
		StdtView.printList(dao.repeatCheckList());
		
	}

}
