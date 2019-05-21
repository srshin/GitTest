package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import model.EmployeeDTO;
import util.OracleDBUtil;

public class DBTest4 {

	public static List<EmployeeDTO> oracleTest() {
		Connection conn = null; 
		Statement st = null;
		ResultSet rs = null;
		String sql ="select first_name, department_name from employees "
				+ "join departments using (department_id) where department_id = 60";
		conn = OracleDBUtil.dbConnect();
		EmployeeDTO emp=null;
		List<EmployeeDTO> empList = new ArrayList<>();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next() ) {
				String fname = rs.getString(1);
				String dname = rs.getString("department_name");
				 emp = new EmployeeDTO(fname, dname);
				 empList.add(emp);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		OracleDBUtil.dbDisconnect(rs, st, conn);
		return empList; 
	}
	public static void main(String[] args) {
		 List<EmployeeDTO> empList = oracleTest(); 
		System.out.println(empList);
	}
}
