package controller;
/* -----------------------------------------------
 * MiniProject  - 전처리 (table create) 
1. major.csv를 참조하여 table을 생성한다. 
2. student.csv를 참조하여 table을 생성한다. 
--------------------------------------------------
다음 요구사항을 작성한다.
1. major.csv 파일의 내용이 major테이블에 입력되도록한다.
2. student.csv 파일의 내용이 student테이블에 입력되도록한다.
3. major 테이블에 추가,삭제,수정,조회되는(CRUD) 기능을 되도록한다.
4. student테이블에 추가,삭제,수정,조회되는(CRUD) 기능을 되도록한다.
5. 모든 학생이름, 전공이름이 조회되는 기능을 추가한다. 
6. 다양한 조건으로 (조건은 가변)  학생이름, 전공이름이 조회되는 기능을 추가한다. 
*/

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

import model.Service;
import valueObject.MajorVO;
import valueObject.StudentVO;
import valueObject.VO;
import valueObject.VOType;
import view.MiniView;

public class MiniController {
	static Service service;
	static Scanner sc;
	
	public static void main(String[] args) {
		service = new Service();
		service.start(VOType.MAJOR);
		service.start(VOType.STUDENT);
		service.start(VOType.MAJOR_STUDENT);

		sc = new Scanner(System.in);
		do {
			switch (menuSelect()) {
			case 12: selectAllController(VOType.MAJOR_STUDENT); break;
			case 2:  selectAllController(VOType.STUDENT);  break;
			case 7:  selectAllController(VOType.MAJOR); break;
			case 3:  selectController(VOType.STUDENT);  break;
			case 8:  selectController(VOType.MAJOR); break;
			case 5:  deleteController(VOType.STUDENT); break; 
			case 10: deleteController(VOType.MAJOR); break;
			case 4:  studentInsertController(VOType.STUDENT); break;
			case 6:  studentUpdateController(VOType.STUDENT); break;
			case 9:  majorInsertController(VOType.MAJOR); break;
			case 11: majorUpdateController(VOType.MAJOR); break;
			case 13: majorStudentSelectController(); break;
			case 15: 
					service.createTable(VOType.MAJOR);
					service.createTable(VOType.STUDENT);
					break;
			case 0:
			default: System.out.println("시스템을 종료합니다."); System.exit(0);
			}
		} while (true);
	}

	private static int menuSelect() {
		System.out.println("=============================================================================");
		System.out.println("서비스 번호를 입력하세요.");
		System.out.println("2.학생 모두 조회 3. 학생 개별 조회   4.학생 추가   5.학생삭제   6.학생수정");
		System.out.println("7.전공 모두 조회 8. 전공 개별 조회  9.전공추가     10.전공삭제  11.전공 수정  ");
		System.out.println("12. 학생이름과 전공이름 조회   13.다양한 조건으로 (조건은 가변)  학생이름, 전공이름이 조회");
		System.out.println(" 0.Exit                   15. 파일에서 데이타 읽어서 데이타베이스에 저장하기   ");
		int i= 0;
		i = sc.nextInt(); 
		return i;
	}

	private static void selectAllController(VOType major) {
		List<VO> list = null;
		list = service.selectAll(major);
		MiniView.display(list);
	}

	private static void selectController(VOType type) {
		System.out.println("번호를 입력하세요. ");
		int no = sc.nextInt();
		VO vo = null;
		vo = service.selectById(no, type);
		MiniView.display(vo);
	}
	
	private static void deleteController(VOType type) {
		System.out.println("삭제할 번호를 입력하세요. ");
		int no = sc.nextInt();
		int result = service.delete(no, type);
		MiniView.display(result + "건 삭제");
	}

	private static void studentInsertController(VOType type) {
		try {
			System.out.println("추가할 학생의 아이디/이름/전공/전화번호/주소/취미/기술을 입력하세요");
			VO vo = new StudentVO(sc.nextInt(), sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next());
			int ret = service.insert(vo, type);
			MiniView.display(ret + "건입력");
		} catch (IllegalArgumentException e) {
			System.out.println("입력 형식이 잘못되었습니다. ");
		}
	}
	
	private static void studentUpdateController(VOType type) {
		System.out.println("수정할 학생 번호를 입력하세요.");
		int no = sc.nextInt();
		System.out.println("수정할 학생의 이름/전공/전화번호/주소/취미/기술을 입력하세요");
		try {
			VO vo = new StudentVO(no, sc.next(), sc.nextInt(), sc.next(), sc.next(), sc.next(), sc.next());
			int ret = service.update(vo, type);
			MiniView.display(ret + "건 수정");
		} catch (IllegalArgumentException e) {
			System.out.println("입력 형식이 잘못되었습니다.");
		}
	}
	
	private static void majorInsertController(VOType major) {
		try {
			System.out.println("추가할 전공의 아이디/과목명을 입력하세요");
			VO vo = new MajorVO(sc.nextInt(), sc.next());
			int ret = service.insert(vo, major);
			MiniView.display(ret + "건입력");
		} catch (IllegalArgumentException e) {
			System.out.println("입력 형식이 잘못되었습니다. ");
		}
	}

	private static void majorUpdateController(VOType major) {
		System.out.println("수정할 전공 번호를 입력하세요.");
		int no = sc.nextInt();
		System.out.println("수정할 과목명을 입력하세요");
		try {
			VO vo = new MajorVO(no, sc.next());
			int ret = service.update(vo, major);
			MiniView.display(ret + "건 수정");
		} catch (IllegalArgumentException e) {
			System.out.println("입력 형식이 잘못되었습니다.");
		}
	}
	
	private static void majorStudentSelectController() {
		{
			Map<String, String> cond = new HashMap<>();
			System.out.println ("검색할 조건을 입력하세요, 멈추려면 Q를 입력하세요");
			do {
				String st1 = sc.next();
				if (st1.equals("q") ) break;
				String st2 = sc.next();
				if (st2.equals("q") ) break;
				cond.put(st1, st2);
			} while (true);
			System.out.println("cond");
			for (String key : cond.keySet()) {
				System.out.println(" cond: " + key +  cond.get(key));}

			List<VO> list = service.jointSelectAll(cond);
			MiniView.display(list);
		}
	}
}
