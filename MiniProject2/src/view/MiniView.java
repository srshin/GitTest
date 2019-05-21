package view;

import java.util.List;

import valueObject.VO;

public class MiniView {


	public static void display(List<VO> list) {
		if (list == null || list.size() == 0) {
			display("정보가 없습니다");
			return;
		}
		System.out.println("========================여러 건의 정보=========================");
		for (VO vo : list) {
			System.out.println(vo);
		}
	}
	public static void display(VO vo) {
		if (vo == null) {
			display("정보가 없습니다");
			return; 
		}
		System.out.println("========================한 건의 정보=========================");
		System.out.println(vo);
	}
	

	public static void display(String message) {
		System.out.println("========================알림=========================");
		System.out.println(message);
	}

}
