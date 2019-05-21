package model;

import java.sql.CallableStatement;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Types;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;


import util.OracleDBUtil;

public class EmpDAO {

	private BDVO makeEmp(ResultSet rs) throws SQLException {
		BDVO emp = new BDVO(rs.getInt("employee_id"), 
				rs.getString("first_name"), 
				rs.getString("last_name"), 
				rs.getString("email"), 
				rs.getString("phone_number"), 
				rs.getDate("hire_date"), 
				rs.getString("job_id"), 
				rs.getInt("salary"), 
				rs.getDouble("commission_pct"), 
				rs.getInt("manager_id"), 
				rs.getInt("department_id")
				);

		return emp;
	}
	
	public List<BDVO> selectAll() {
		Connection conn = null;
		Statement st = null; 
		ResultSet rs = null; 
		BDVO  emp = null; 
		List<BDVO> empList = new ArrayList<>();
		String sql = "select * from employees order by employee_id";
		conn = OracleDBUtil.dbConnect();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				emp = makeEmp(rs);
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		
		return empList; 
	}
	

	public BDVO selectById(int empId) {
		Connection conn = null;
		Statement st = null; 
		ResultSet rs = null; 
		BDVO  emp = null; 
		String sql = "select * from employees where employee_id="+empId;
		conn = OracleDBUtil.dbConnect();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				emp = makeEmp(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		
		return emp; 
	}
	
	public List<BDVO> selectByDept(int deptId) {
		Connection conn = null;
		Statement st = null; 
		ResultSet rs = null; 
		BDVO  emp = null; 
		List<BDVO> empList = new ArrayList<>();
		String sql = "select * from employees where department_id="+deptId;
		conn = OracleDBUtil.dbConnect();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				emp = makeEmp(rs);
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		
		return empList; 
	}
	public List<BDVO> selectBySalary(int salary) {
		Connection conn = null;
		Statement st = null; 
		ResultSet rs = null; 
		BDVO  emp = null; 
		List<BDVO> empList = new ArrayList<>();
		String sql = "select * from employees where salary>="+salary;
		conn = OracleDBUtil.dbConnect();
		
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				emp = makeEmp(rs);
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		
		return empList; 
	}

	public List<BDVO> selectByDeptJob(int deptId, String jobId) {
		Connection conn = null;
		PreparedStatement st = null; 
		ResultSet rs = null; 
		BDVO  emp = null; 
		List<BDVO> empList = new ArrayList<>();
		String sql = "select * from employees where department_id=?" 
					+ "and job_id=?";
		conn = OracleDBUtil.dbConnect();
		
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, deptId);
			st.setString(2, jobId);
			rs = st.executeQuery();
			while (rs.next()) {
				emp = makeEmp(rs);
				empList.add(emp);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		
		return empList; 
	}
	
	public int insertEmp(BDVO emp) {
		Connection conn = null;
		int result =0; 
		PreparedStatement st = null;
		String sql = "insert into employees values(?,?,?,?,?,?,?,?,?,?,?)";
		conn = OracleDBUtil.dbConnect();
		try {
			st= conn.prepareStatement(sql);
			st.setInt   (1, emp.getEmployee_id());
			st.setString(2, emp.getFirst_name());
			st.setString(3, emp.getLast_name());
			st.setString(4, emp.getEmail());
			st.setString(5, emp.getPhone_number());
			st.setDate  (6, emp.getHire_date());
			st.setString(7, emp.getJob_id());
			st.setInt   (8, emp.getSalary());
			st.setDouble(9, emp.getCommission_pct());
			st.setInt  (10, emp.getManager_id());
			st.setInt  (11, emp.getDepartment_id());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}
		return result; 
	}

	public int updateEmp(BDVO emp) {
		Connection conn = null;
		int result =0; 
		PreparedStatement st = null;
		String sql = "update employees set first_name=?, last_name=?, email=?, phone_number=?, "
				+ " hire_date=? where employee_id=?";
		conn = OracleDBUtil.dbConnect();
		try {
			st= conn.prepareStatement(sql);
			st.setString(1, emp.getFirst_name());
			st.setString(2, emp.getLast_name());
			st.setString(3, emp.getEmail());
			st.setString(4, emp.getPhone_number());
			st.setDate  (5, emp.getHire_date());
			st.setInt   (6, emp.getEmployee_id());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}
		return result; 
	}
		
	public int deleteEmp(int empId) {
		Connection conn = null;
		int result =0; 
		PreparedStatement st = null;
		String sql = "delete from employees where employee_id=?";
		conn = OracleDBUtil.dbConnect();
		try {
			st= conn.prepareStatement(sql);
			st.setInt   (1, empId);
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}
		return result; 
	}

	public int updateEmpBySal(int salary) {
		Connection conn = null;
		int result =0; 
		PreparedStatement st = null;
		String sql = "update employees set salary=salary*1.1 where salary >=?";
		conn = OracleDBUtil.dbConnect();
		try {
			conn.setAutoCommit(false);
			st= conn.prepareStatement(sql);
			st.setInt (1, salary);
			result = st.executeUpdate();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}
		return result; 
	}

	public Map<String, Object> executeTest(String sql) {
		Map<String, Object> data = new HashMap<String, Object>(); 
		Connection conn = OracleDBUtil.dbConnect();
		Statement st = null; 
		ResultSet rs = null; 
		try {
			st =  conn.createStatement();
			boolean isSelect = st.execute(sql);
			if (isSelect) { //SELECT
				rs = st.getResultSet();
				List<BDVO> empList = new ArrayList<>();
				while (rs.next() ) {
					empList.add(makeEmp(rs));
				}
				data.put("select", empList);
			} else  {	//DML
				int result = st.getUpdateCount();
				data.put("update", result);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		return data;
	}

	public int[] addBatchTest(String[] jobs) {
		Connection conn = null;
		Statement st = null;
		int[] result = null;
		conn = OracleDBUtil.dbConnect();
		try {
			conn.setAutoCommit(false); //auto commit false 
			st = conn.createStatement();
			for (String sql:jobs) {
				st.addBatch(sql);
			}
			result = st.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}
		return result;
	}

	public int plsqlTest(int sal, double rate) {
		int result = 0; 
		Connection conn = null;
		CallableStatement st = null; 
		String sql= "{call pro_tax(?,?,?)}";
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.prepareCall(sql);
			st.setInt(1, sal);
			st.setDouble(2, rate);
			st.registerOutParameter(3, Types.INTEGER);
			st.executeUpdate();
			result = st.getInt(3);
		} catch (SQLException e) {
			e.printStackTrace();
		}
		return result;
	}

}
