package controller;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import model.EmpService;
import model.BDVO;
import view.EmpView;

public class EmpController2 {
	public static void main(String[] args) {
		System.out.print("작업선택 1. 조회    2. 수정 >> ");
		Scanner sc = new Scanner(System.in);
		int job = sc.nextInt();
		EmpService service = new EmpService();
		Map<String, Object> data = service.executeTest(job);
		
		
		for (String key : data.keySet()) {
			System.out.println(key);
			Object obj = data.get(key);
			if (obj instanceof List) {
				List<BDVO> empList = (ArrayList)obj;
				EmpView.display(empList);
			}else {
				Integer count = (Integer)obj;
				EmpView.display(count + "건 수정");
			}
		}
	}
}
