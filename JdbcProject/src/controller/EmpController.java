package controller;

import java.sql.Date;
import java.util.List;
import java.util.Scanner;

import model.EmpService;
import model.BDVO;
import view.EmpView;

public class EmpController {

	public static void main(String[] args) {
		EmpService service = new EmpService();
		// 1. 모든 직원 조회
		{
			List<BDVO> empList = null;
			empList = service.selectAll();
			EmpView.display(empList);
		}
		// 2.직원 아이디로 조회하기
/*		{
			Scanner sc = new Scanner(System.in);
			System.out.println("직원 번호를 입력하세요. ");
			int empId = sc.nextInt();
			EmpVO emp = null;
			emp = service.selectById(empId);
			EmpView.display(emp);
		}
		//3. 부서 아이디로 조회
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("부서 번호를 입력하세요. ");
			int deptId = sc.nextInt();
			List<EmpVO> empList = null;
			empList = service.selectByDept(deptId);
			EmpView.display(empList);
		}
*/
		//4. 특정 salary보다 많이 받는 직원 조회 
/*		{
			Scanner sc = new Scanner(System.in);
			System.out.println("salary를 입력하세요. ");
			int salary = sc.nextInt();
			List<EmpVO> empList = null;
			empList = service.selectBySalary(salary);
			EmpView.display(empList);
			sc.close();
		}

*/		//5. 특정 department id와 job id를 갖는 직원 조회 
/*		{
			Scanner sc = new Scanner(System.in);
			System.out.println("부서 아이디를 입력하세요. ");
			int deptId = sc.nextInt();
			System.out.println("job id를 입력하세요. ");
			String jobId= sc.next();
			List<EmpVO> empList = null;
			empList = service.selectByDeptJob(deptId, jobId);
			EmpView.display(empList);
			sc.close();
		}
*/				
		//6. 새로운 데이타를 입력
		/*{
			Scanner sc = new Scanner(System.in);
			System.out.println("번호/이름/성/이메일/전화번호/입사일(yyyy-mm-dd)/Job/salary/commision/매니저 아이디/부서 아이디 을 입력하세요. ");
			int empId = sc.nextInt();
			try {
				EmpVO emp= new EmpVO(empId, sc.next(), sc.next(), sc.next(), sc.next(), 
				Date.valueOf(sc.next()), sc.next(), sc.nextInt(), sc.nextDouble(), sc.nextInt(), sc.nextInt());
				int ret = service.insertEmp(emp); 
				EmpView.display(ret+"건입력");
				EmpView.display(service.selectById(empId));
			} catch ( IllegalArgumentException e) {
				System.out.println("입사일 형식이 잘못되었습니다.yyyy-mm-dd ");
			}
		}*/
		//7. 데이타 수정
/*		{
			Scanner sc = new Scanner(System.in);
			System.out.println("수정할 번호/이름/성/이메일/전화번호/입사일(yyyy-mm-dd)을 입력하세요. ");
			int empId = sc.nextInt();
			try {
				EmpVO emp= new EmpVO(empId, sc.next(), sc.next(), sc.next(), sc.next(), 
				Date.valueOf(sc.next()), null, 0, 0, 0, 0);
				int ret = service.updateEmp(emp); 
				EmpView.display(ret+"건 수정");
				EmpView.display(service.selectById(empId));
			} catch ( IllegalArgumentException e) {
				System.out.println("입사일 형식이 잘못되었습니다.yyyy-mm-dd ");
			}
		}
*/		
		//8. 데이타 삭제
/*		{
			Scanner sc = new Scanner(System.in);
			System.out.println("삭제할 직원아이디를 입력하세요. ");
			int empId = sc.nextInt();
			int ret = service.deleteEmp(empId); 
			EmpView.display(ret+"건 삭제");
			EmpView.display(service.selectById(empId));
		}
*/		//9. salary 수정 
		{
			Scanner sc = new Scanner(System.in);
			System.out.println("급여인상할 급여 액수를  입력하세요. ");
			int salary = sc.nextInt();
			int ret = service.updateEmpBySal(salary); 
			EmpView.display(ret+"건 수정");
			List<BDVO>  empList = service.selectBySalary(salary);
			EmpView.display(empList);
		}
	}

}
