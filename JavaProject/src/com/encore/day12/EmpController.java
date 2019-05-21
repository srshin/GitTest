package com.encore.day12;

import java.io.IOException;
import java.util.List;
import java.util.Scanner;

public class EmpController {

	public static void main(String[] args) throws IOException {

		// [1] 파일에서 데이타를 읽어들인다.
		EmpDAO dao = new EmpDAO();
		EmpView view = new EmpView();
		List<EmpDTO> list = dao.selectAll();

		// [2]메뉴를 출력하고 사용자의 선택을 입력받는다.

		// 1. 모든 직원의 데이타를 보여준다
		// 2. 급여가 ..이상인 직원의 정보를 보여준다.
		// 3. 부서가 ..인 직원의 정보를 보여준다.
		// 4. 업무가 ..인 직원의 정보를 보여준다.
		Scanner sc = new Scanner(System.in);
		while (true) {
			System.out.println("1. 모든 직원의 데이타 출력");
			System.out.print("2. 급여 찾기  ");
			System.out.print("3. 부서찾기     ");
			System.out.print("4. 업무찾기   ");
			System.out.print("5. 매니저찾기   ");
			System.out.print("6. 직원이름 찾기   ");
			System.out.println("9. 메뉴 종료 ");
			int i = sc.nextInt();
			if (i == 9) {
				System.out.println("프로그램을 종료합니다");
				sc.close();
				break;
			}
			switch (i) {
			case 1:// 모든 직원의 데이타를 출력한다.
				view.show(list);
				break;
			case 2:
				System.out.println("급여를 입력하세요");
				view.show(dao.selectBySalary(EmpDAO.SALARY, sc.nextInt()));
				break;
			case 3:
				System.out.print("부서코드를 입력하세요: ");
				dao.menuList(EmpDAO.DEPT_ID);
				view.show(dao.selectByDept(EmpDAO.DEPT_ID, sc.next()));
				break;
			case 4:
				System.out.print("업무코드를 입력하세요: ");
				dao.menuList(EmpDAO.JOB_ID);
				view.show(dao.selectByDept(EmpDAO.JOB_ID, sc.next()));
				break;
			case 5:
				System.out.print("매니저 코드를 입력하세요: ");
				dao.menuList(EmpDAO.MANAGER_ID);
				view.show(dao.selectByDept(EmpDAO.MANAGER_ID, sc.next()));
				break;
			case 6:
				System.out.print("직원이름을 입력하세요: ");
				String str= sc.next();
				System.out.println("FIRST NAME");
				view.show(dao.selectByDept(EmpDAO.FIRST_NAME, str));
				System.out.println("LAST NAME");
				view.show(dao.selectByDept(EmpDAO.LAST_NAME, str));
				break;
			default:
				System.out.println("프로그램을 종료합니다");
				break;
			}
		}
	}
}
