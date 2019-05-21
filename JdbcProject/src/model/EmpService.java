package model;

import java.util.List;
import java.util.Map;

//business logic
public class EmpService {
	EmpDAO dao = new EmpDAO();
	
	public List<BDVO> selectAll() {
		return dao.selectAll(); 
	}
	
	public BDVO selectById(int empId) {
		return dao.selectById(empId); 
	}
	
	public List<BDVO> selectByDept(int deptId) {
		return dao.selectByDept(deptId); 
	}
	public List<BDVO> selectBySalary(int salary) {
		return dao.selectBySalary(salary); 
	}

	public List<BDVO> selectByDeptJob(int deptId, String jobId) {
		return dao.selectByDeptJob(deptId, jobId); 
	}
	
	public int insertEmp(BDVO emp) {
		return dao.insertEmp(emp); 
	}

	public int updateEmp(BDVO emp) {
		return dao.updateEmp(emp); 
	}
		
	public int deleteEmp(int empId) {
		return dao.deleteEmp(empId); 
	}

	public int updateEmpBySal(int salary) {
		return dao.updateEmpBySal(salary); 
	}

	public Map<String, Object> executeTest(int job) {
		//1. 조회
		String sql = "";
		if(job == 1) {
			sql = "select * from employees";
		} else if(job ==2) {
		//2. 수정	
			sql = "update employees set commission_pct =0.5";
			
		} else {
			sql="";
		}
		return dao.executeTest(sql);
	}

	public int[] addBatchTest(Map<Integer, String> data) {

		String[] jobs = new String[3];
		int i=0;
		for( int key: data.keySet()) {
		jobs[i++] = "update employees set first_name='"
				+ data.get(key)
				+ "' where employee_id="
				+ key;
		}
		
		return dao.addBatchTest(jobs);
	}

	public int plsqlTest(int sal, double rate) {
		return dao.plsqlTest(sal, rate);
	}
	
}
