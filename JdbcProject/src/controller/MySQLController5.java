package controller;

import java.util.List;

import model.EmpServiceMySQL;
import model.MySQLVO;
import view.EmpViewMySQL;

public class MySQLController5 {

	public static void main(String[] args) {
		EmpServiceMySQL service = new EmpServiceMySQL();
	// 1. 모든 직원 조회
		List<MySQLVO> empList = null;
		empList = service.selectAll(5);
		EmpViewMySQL.display(empList);
	}

}
