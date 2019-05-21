package util;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;


public class MySQLDBUtil {
 
		//DB연결 
		public static Connection dbConnect() {
			Connection conn = null;
			String url="jdbc:mysql://localhost:3306/employees?useSSL=true&verifyServerCertificate=false";  
			String user = "root";
			String password = "1234";
			try {
				Class.forName("com.mysql.jdbc.Driver");
				conn = DriverManager.getConnection(url, user, password);
			} catch (ClassNotFoundException | SQLException e) {
				e.printStackTrace();
			}
			return conn; 
		}
		//DB연결 해제
		public static void dbDisconnect(ResultSet rs, Statement st, Connection conn) {
			try {
				if (rs != null) rs.close();
				if (st != null) st.close();
				if (conn != null) conn.close();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
}
