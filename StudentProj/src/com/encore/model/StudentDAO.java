package com.encore.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.encore.util.OracleDBUtil;
import valueObject.StudentVO;
import valueObject.VO;

public class StudentDAO implements DAO {

	private StudentVO makeStudentVO(ResultSet rs) throws SQLException {
		StudentVO student = new StudentVO(rs.getString("student_id"),  rs.getString("password"), rs.getString("sname"), rs.getString("major_id"),
				rs.getString("phone"), rs.getString("address"), rs.getString("hobby"), rs.getString("skill"));

		return student;
	}

	public List<VO> selectAll() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		StudentVO bd = null;
		List<VO> BDList = new ArrayList<>();
		String sql = "select * from student order by to_number(student_id)";
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				bd = makeStudentVO(rs);
				BDList.add(bd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}

		return BDList;
	}

	public StudentVO selectById(String no) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		StudentVO bd = null;
		String sql = "select * from student where student_id= '" + no+"'";
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				bd = makeStudentVO(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		return bd;
	}
	

	public int insertAll(List<VO> list) {
		Connection conn = null;
		Statement st = null;
		int[] result = null;
		conn = OracleDBUtil.dbConnect();
		try {
			conn.setAutoCommit(false); // auto commit false
			st = conn.createStatement();
			for (VO vo : list) {
				StudentVO s = (StudentVO) vo;
				String sql = " insert into student values(" + s.getStudentId()+ ", "
						+ "'" + s.getPassword() + "', "
						+ "'" + s.getName() + "',"
						+ s.getMajorId() + ", '" 
						+ s.getPhone() + "', '" 
						+ s.getAddress() + "', '" 
						+ s.getHobby() + "', '" 
						+ s.getSkill() + "')";
				System.out.println(sql);
				st.addBatch(sql);
			}
			result = st.executeBatch();
			conn.commit();
		} catch (SQLException e) {
			e.printStackTrace();
			try {
				conn.rollback();
			} catch (SQLException e1) {
				e1.printStackTrace();
			}
		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}
		int count = 0;
		for (int i : result) {
			count += i;
		}
		return count;
	}

	public int insert(VO vo) {
		Connection conn = null;
		PreparedStatement st = null;
		int result = 0;
		conn = OracleDBUtil.dbConnect();
		String sql = " insert into student values( ?,?,?,?,?,?,?, ?)";

		try {
			st = conn.prepareStatement(sql);
			StudentVO s = (StudentVO) vo;
			st.setString(1, s.getStudentId());
			st.setString(2, s.getPassword());
			st.setString(3, s.getName());
			st.setString(4, s.getMajorId());
			st.setString(5, s.getPhone());
			st.setString(6, s.getAddress());
			st.setString(7, s.getHobby());
			st.setString(8, s.getSkill());
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}
		return result;
	}

	public int delete(int no) {
		Connection conn = null;
		int result = 0;
		PreparedStatement st = null;
		String sql = "delete from student where student_id=?";
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, no);
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}
		return result;
	}

	public int update(VO vo) {
		Connection conn = null;
		int result = 0;
		PreparedStatement st = null;
		String sql = "update student set password=?, sname=?, major_id =?, phone=?, address=?, hobby=?, skill=? where student_id=?";
		System.out.println(sql);
		conn = OracleDBUtil.dbConnect();
		try {
			StudentVO s = (StudentVO) vo;
			st = conn.prepareStatement(sql);
			st.setString(1, s.getPassword());
			st.setString(2, s.getName());
			st.setString(3, s.getMajorId());
			st.setString(4, s.getPhone());
			st.setString(5, s.getAddress());
			st.setString(6, s.getHobby());
			st.setString(7, s.getSkill());
			st.setString(8, s.getStudentId());
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}
		return result;
	}

	@Override
	public VO loginCheck(String userid, String userpass) {
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		VO vo = null; 
		System.out.println(userid);
		System.out.println(userpass);
		String sql = "select * from student where student_id = ? and password = ?";
		System.out.println(sql);
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, userid);
			st.setString(2, userpass);
			rs = st.executeQuery();
			if(rs.next())	vo = new StudentVO(rs.getString("student_id"), 
					rs.getString("password"), 
					rs.getString("sname"), 
					rs.getString("major_Id"),
					rs.getString("phone"),
					rs.getString("address"),
					rs.getString("hobby"),
					rs.getString("skill"));
			System.out.println(vo);
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("로그인체크 에러  ");
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		return vo;
	}

	@Override
	public int deleteAll() {
		Connection conn = null;
		int result = 0;
		PreparedStatement st = null;
		String sql = "delete from student";
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.prepareStatement(sql);
			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			result = -1;
			System.out.println("삭제시 에러 발생");
		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}
		System.out.println(result);
		return result;
	}

}
