package view;

import java.util.List;

import model.BDVO;

public class EmpView {

	public static void display(BDVO emp) {
		if (emp== null) {
			display("정보가 없습니다");
			return; 
		}
		System.out.println("========================한 건의 정보=========================");
		System.out.println(emp);
	}
	
	public static void display(List<BDVO> emps) {
		if (emps== null || emps.size()==0) {
			display("정보가 없습니다");
			return; 
		}
		System.out.println("========================여러 건의 정보=========================");
		for (BDVO emp: emps) {
			System.out.println(emp);
		}
	}
	
	public static void display(String message) {
		System.out.println("========================알림=========================");
		System.out.println(message);
	}
	
}
