package com.encore.day20;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

public class DBConnect {

	public static void main(String[] args) throws ClassNotFoundException, SQLException {
		//자바에서 DB사용하기
		//1. driver load
		//2. DB connect
		//3. SQL 문장 실행
		//4. 실행 결과 가져오기
		//5. DB연결 해제
		Class.forName("oracle.jdbc.driver.OracleDriver");
		System.out.println("드라이버 로딩 성공 ");
		
		Connection conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "hr", "hr") ;
		System.out.println("DB연결 성공"+conn);
		String sql="select * from employees";
		Statement st = conn.createStatement();
		ResultSet rs = st.executeQuery(sql);
		while(rs.next()) {
			int eid = rs.getInt(1);
			String fname = rs.getString(2);
			int sal = rs.getInt("salary");
			System.out.println(eid +"---"+ fname+"----"+sal);
		}
		conn.close();
	}
}
