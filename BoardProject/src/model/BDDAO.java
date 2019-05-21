package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import util.OracleDBUtil;

public class BDDAO {

	private BDVO makeBD(ResultSet rs) throws SQLException {
		BDVO bd = new BDVO(rs.getInt("bno"), 
				rs.getString("title"), 
				rs.getString("contents"), 
				rs.getString("writer"), 
				rs.getDate("regdate"), 
				rs.getInt("count") 
				);

		return bd;
	}
	
	public List<BDVO> selectAll() {
		Connection conn = null;
		Statement st = null; 
		ResultSet rs = null; 
		BDVO  bd = null; 
		List<BDVO> BDList = new ArrayList<>();
		String sql = "select * from board order by bno";
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				bd = makeBD(rs);
				BDList.add(bd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		
		return BDList; 
	}
	
	public BDVO selectById(int bdno) {
		Connection conn = null;
		Statement st = null; 
		ResultSet rs = null; 
		BDVO  bd = null; 
		String sql = "select * from board where bno="+bdno;
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				bd = makeBD(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		return bd; 
	}
	
	public int insertBD(BDVO bd) {
		Connection conn = null;
		int result =0; 
		PreparedStatement st = null;
		String sql = "insert into board (bno, title, contents, writer) values(seq_boardNo.nextval, ?, ? , ?)"; 
		conn = OracleDBUtil.dbConnect();
		try {
			st= conn.prepareStatement(sql);
			st.setString(1, bd.getTitle());
			st.setString(2, bd.getContents());
			st.setString(3, bd.getWriter());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}
		return result; 
	}

	public int deleteBD(int bdno) {
		Connection conn = null;
		int result =0; 
		PreparedStatement st = null;
		String sql = "delete from board where bno=?";
		conn = OracleDBUtil.dbConnect();
		try {
			st= conn.prepareStatement(sql);
			st.setInt   (1, bdno);
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}
		return result; 
	}

	public int updateBD(BDVO bd) {
		Connection conn = null;
		int result =0; 
		PreparedStatement st = null;
		String sql = "update board set title=?, contents=? where bno=?";
		conn = OracleDBUtil.dbConnect();
		try {
			st= conn.prepareStatement(sql);
			st.setString(1, bd.getTitle());
			st.setString(2, bd.getContents());
			st.setInt   (3, bd.getBno());
			
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}
		return result; 
	}
		
	public int updateBD(int bdno) {
		Connection conn = null;
		int result =0; 
		PreparedStatement st = null;
		String sql = "update board set count=count+1 where bno=?";

		conn = OracleDBUtil.dbConnect();
		try {
			st= conn.prepareStatement(sql);
			st.setInt(1, bdno);
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}
		return result; 
		
	}


}
