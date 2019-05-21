package com.encore.day18_2;

public class StdController {
	
	public static void main(String[] args) {
		
		StdDAO dao = new StdDAO();
		StdView view = new StdView();
		
		view.printList(dao.repeatCheckList());
		
	}

}
