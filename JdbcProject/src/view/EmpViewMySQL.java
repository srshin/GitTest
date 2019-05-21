package view;

import java.util.List;

import model.MySQLVO;

public class EmpViewMySQL {
	public static void display(List<MySQLVO> emps) {
		if (emps== null || emps.size()==0) {
			display("정보가 없습니다");
			return; 
		}
		System.out.println("========================여러 건의 정보=========================");
		for (MySQLVO emp: emps) {
			System.out.println(emp);
		}
	}
	public static void display(String message) {
		System.out.println("========================알림=========================");
		System.out.println(message);
	}

}
