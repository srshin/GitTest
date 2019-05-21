package controller;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

import model.EmpService;
import view.EmpView;

public class EmpController3 {
	public static void main(String[] args) {
		//서로 다른 여건의 SQL문을 수행
		Map<Integer, String> data = new HashMap<>();
		data.put(100, "Sangrim");
		data.put(101, "Sangrim");
		data.put(102, "Sangrim");
		EmpService service = new EmpService();
		int[] result = service.addBatchTest(data);
		EmpView.display(Arrays.toString(result) + "건 영향받음");
		
	}
}
