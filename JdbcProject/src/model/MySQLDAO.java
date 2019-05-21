package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.LinkedList;
import java.util.List;

import util.MySQLDBUtil;

public class MySQLDAO {
	public List<MySQLVO> selectAll(int limit) {
		List<MySQLVO> empList = new LinkedList<>(); 
		Connection conn = null;
		PreparedStatement ps= null;
		ResultSet rs = null;
		String sql = "select * from employees limit ?";
		conn= MySQLDBUtil.dbConnect();
		try {
			ps = conn.prepareStatement(sql);
			ps.setInt(1, limit);
			rs = ps.executeQuery();
			while(rs.next() ) {
				MySQLVO emp  = makeEmp(rs);
				empList.add(emp);
			}
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			MySQLDBUtil.dbDisconnect(rs, ps, conn);
		}
		return empList; 
	}

	private MySQLVO makeEmp(ResultSet rs) {
		MySQLVO emp=null;
		try {
			emp = new MySQLVO(rs.getInt("emp_no"), 
							rs.getString("first_name"), 
							rs.getString("last_name"),
							Gender.valueOf(rs.getString("gender")), 
							rs.getDate("hire_date"), 
							rs.getDate("birth_date"));
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return emp;
	}
}
