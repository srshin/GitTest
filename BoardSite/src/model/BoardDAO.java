package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;


import util.OracleDBUtil;

public class BoardDAO {

	private BoardVO makeBD(ResultSet rs) throws SQLException {
		BoardVO bd = new BoardVO(rs.getInt("bno"), 
				rs.getString("title"), 
				rs.getString("contents"), 
				rs.getString("writer"), 
				rs.getDate("regdate"), 
				rs.getInt("count") 
				);

		return bd;
	}
	
	public List<BoardVO> selectAll() {
		Connection conn = null;
		Statement st = null; 
		ResultSet rs = null; 
		BoardVO  bd = null; 
		List<BoardVO> BDList = new ArrayList<>();
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
	
	public BoardVO selectById(int bdno) {
		Connection conn = null;
		Statement st = null; 
		ResultSet rs = null; 
		BoardVO  bd = null; 
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
	
	public int insertBD(BoardVO bd) {
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

	public int updateBD(BoardVO bd) {
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

	public void display(BoardVO bd) {
		if (bd== null) {
			display("정보가 없습니다");
			return; 
		}
		System.out.println("========================한 건의 정보=========================");
		System.out.println(bd);
	}
	
	public void display(List<BoardVO> bdlist) {
		if (bdlist== null || bdlist.size()==0) {
			display("정보가 없습니다");
			return; 
		}
		System.out.println("========================여러 건의 정보=========================");
		for (BoardVO bd:bdlist ) {
			System.out.println(bd);
		}
	}
	
	public void display(String message) {
		System.out.println("========================알림=========================");
		System.out.println(message);
	}

}
