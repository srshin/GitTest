package com.encore.day18_6;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Arrays;

public class SeatListDAO {

	public  ArrayList<String>  readSeatList(){
		ArrayList<String> arrayList= new ArrayList<>(); 
		try {
			Class.forName("oracle.jdbc.driver.OracleDriver");
			System.out.println("드라이버 로딩 성공 ");
			Connection conn=null;
			conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:xe", "SCOTT", "TIGER");
			System.out.println("DB연결 성공");
			String sql="select * from seatlist";
			Statement st;
			st = conn.createStatement();
			ResultSet rs;
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String str = rs.getString("names");
				arrayList = new ArrayList<>(Arrays.asList(str.split("\\s*,\\s*")));
				System.out.println(arrayList.toString());
			}
			conn.close();
		
		} catch (ClassNotFoundException | SQLException e) {
			e.printStackTrace();
		}
		
		return arrayList;
	}
	
	
}
