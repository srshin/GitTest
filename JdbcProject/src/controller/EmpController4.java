package controller;

import model.EmpService;
import view.EmpView;

public class EmpController4 {
	public static void main(String[] args) {
		//stored procedure를 호출하기
		int sal = 10000;
		double rate = 0.03;
		EmpService service = new EmpService();
		int result = service.plsqlTest(sal, rate);
		EmpView.display(result+"  납부");
		
	}
}
