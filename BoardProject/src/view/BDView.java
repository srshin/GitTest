package view;

import java.util.List;

import model.BDVO;

public class BDView {

	public static void display(BDVO bd) {
		if (bd== null) {
			display("정보가 없습니다");
			return; 
		}
		System.out.println("========================한 건의 정보=========================");
		System.out.println(bd);
	}
	
	public static void display(List<BDVO> bdlist) {
		if (bdlist== null || bdlist.size()==0) {
			display("정보가 없습니다");
			return; 
		}
		System.out.println("========================여러 건의 정보=========================");
		for (BDVO bd:bdlist ) {
			System.out.println(bd);
		}
	}
	
	public static void display(String message) {
		System.out.println("========================알림=========================");
		System.out.println(message);
	}
	
}
