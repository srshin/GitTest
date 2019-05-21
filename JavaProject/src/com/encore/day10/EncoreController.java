package com.encore.day10;

import java.util.ArrayList;
import java.util.List;

public class EncoreController {

	public static void insert(List<String> data) {
		data.add("월요일");
		data.add("화요일");
		data.add("수요일");
		data.add("목요일");
		data.add("금요일");
	}

	public static void process(List<String> data) {
		EncoreDAO dao = new EncoreDAO();
		dao.update(data);

	}

	public static void main(String[] args) {
		List<String> data = new ArrayList<>(); 
		// 입력
		insert(data);
		// 처리
		process(data);
		// 출력
		EncoreView.htmlPrint(data);
	}

}
