package test;

import java.sql.Connection;
import java.sql.Date;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import util.OracleDBUtil;

public class DBTest {
	public static void main(String[] args) {
		//driver load
		//db connect
		//statement생성 (sql문 실행통로)
		//sql 실행 (select문) -> 결과는 ResultSet으로
		//결과 받기
		//db연결해제
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null; 
		try {
			conn = OracleDBUtil.dbConnect();
			System.out.println("DB연결 성공");
			String sql = "select * from employees";
			st = conn.createStatement();
			System.out.println("sql문  보내는 통로 생성");
			rs = st.executeQuery(sql);
			System.out.println("sql문  실행후 결과 가져옴. ");
			
			while(rs.next()) { // row로 이동한다. 
				int empid = rs.getInt(1);
				String fname = rs.getString(2);
				int sal = rs.getInt("salary");
				Date hdate =rs.getDate("hire_date");
				System.out.printf("%3d\t%10s\t%10d\t%s\n", empid, fname, sal, hdate);
			}
		} catch (  SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
	}
}
