package test;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.MySQLDBUtil;
import util.OracleDBUtil;

public class DBTest3 {
	public static void mySqlTest() {
		Connection conn = null; 
		Statement st = null;
		ResultSet rs = null;
		String sql ="select dept_no, dept_name from departments ";
		conn = MySQLDBUtil.dbConnect();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next() ) {
				String fname = rs.getString("dept_no");
				String dname = rs.getString("dept_name");
				System.out.println(fname+"\t"+ dname);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		MySQLDBUtil.dbDisconnect(rs, st, conn);
		
	}
	public static void oracleTest() {
		Connection conn = null; 
		Statement st = null;
		ResultSet rs = null;
		String sql ="select first_name, department_name from employees "
				+ "join departments using (department_id) ";
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next() ) {
				String fname = rs.getString(1);
				String dname = rs.getString("department_name");
				System.out.println(fname+"\t"+ dname);
				
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		OracleDBUtil.dbDisconnect(rs, st, conn);
		
	}
	public static void main(String[] args) {
		oracleTest(); 
		mySqlTest();
	}
}
