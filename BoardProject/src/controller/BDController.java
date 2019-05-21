package controller;

import java.util.List;
import java.util.Scanner;

import model.BDService;
import model.BDVO;
import view.BDView;

public class BDController {
	public static void main(String[] args) {
		BDService service = new BDService();
		Scanner sc = new Scanner(System.in);
		do {
			System.out.println("서비스 번호를 입력하세요. 1. 모든 게시판 조회    2. 특정 게시판 조회   3.게시물 추가   4.게시물 삭제   5.게시물 수정   9.Exit");
			int menu = sc.nextInt();
			switch (menu) {
			case 1: // 1. 모든 게시판 조회
			{
				List<BDVO> bdList = null;
				bdList = service.selectAll();
				BDView.display(bdList);
			}
				break;
			case 2: // 2.특정 게시물 조회하기
			{
				System.out.println("게시물번호를 입력하세요. ");
				int bdno = sc.nextInt();
				BDVO bd = null;
				bd = service.selectById(bdno);
				BDView.display(bd);
			}
				break;
			case 3: // 3. 게시물 추가
			{
				System.out.println("입력할 제목/내용을 입력하세요. ");
				try {
					sc.nextLine();
					BDVO bd = new BDVO(0, sc.nextLine(), sc.nextLine(), "신상림", null, 0);
					int ret = service.insertBD(bd);
					BDView.display(ret + "건입력");
				} catch (IllegalArgumentException e) {
					System.out.println("입력 형식이 잘못되었습니다. ");
				}
			}
				break;
			case 4: // 4. 게시물 삭제
			{
				System.out.println("삭제할 게시물 번호를 입력하세요. ");
				int bdno = sc.nextInt();
				int result = service.deleteBD(bdno);
				BDView.display(result + "건 삭제");
				BDView.display(service.selectById(bdno));
			}
				break;
			case 5: // 5. 게시물 수정
			{
				System.out.println("수정할 게시물 번호를 입력하세요.");
				int bdno = sc.nextInt();
				sc.nextLine();
				System.out.println("수정할 게시물 제목/내용을 입력하세요.");
				try {
					BDVO bd = new BDVO(bdno, sc.nextLine(), sc.nextLine(), "신상림", null, 0);
					int ret = service.updateBD(bd);
					BDView.display(ret + "건 수정");
					BDView.display(service.selectById(bdno));
				} catch (IllegalArgumentException e) {
					System.out.println("입력 형식이 잘못되었습니다.");
				}
			}
				break;
			case 9:
				System.out.println("시스템을 종료합니다.");
				sc.close();
				System.exit(0);
			}
		} while (true);
	}
}
