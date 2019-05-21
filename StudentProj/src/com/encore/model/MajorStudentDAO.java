package com.encore.model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.encore.util.OracleDBUtil;
import valueObject.MajorStudentVO;
import valueObject.StudentVO;
import valueObject.VO;

public class MajorStudentDAO implements DAO{

	private MajorStudentVO makeMajorStudentVO(ResultSet rs) throws SQLException {
		MajorStudentVO student = new MajorStudentVO(rs.getInt("student_id"), rs.getString("sname"), 
				 rs.getString("skill"), rs.getInt("major_id"), rs.getString("major_title") );

		return student;
	}
	
	@Override
	public List<VO> selectAll() {
		String sql = "select student_id, password, sname, major_id, major_title, phone, address,hobby, skill "
				+ "from student join major using (major_id)";
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		VO vo = null;
		List<VO> list = new ArrayList<>();
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				vo = new StudentVO(rs.getString("student_id"),
						rs.getString("password"),
						rs.getString("sname"),
						rs.getString("major_id"),
						rs.getString("phone"),
						rs.getString("address"),
						rs.getString("hobby"),
						rs.getString("skill"),
						rs.getString("major_title"));
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		return list;
	}

	public List<VO> jointSelectAll(String sql) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		MajorStudentVO vo = null;
		List<VO> list = new ArrayList<>();
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				vo = makeMajorStudentVO(rs);
				list.add(vo);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		return list;
	}

	@Override
	public int insertAll(List<VO> list) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public VO selectById(String no) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int insert(VO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int delete(int no) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public int update(VO vo) {
		// TODO Auto-generated method stub
		return 0;
	}

	@Override
	public VO loginCheck(String userid, String userpass) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return 0;
	}


}
