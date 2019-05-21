package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.OracleDBUtil;
import valueObject.StudentVO;
import valueObject.VO;

public class StudentDAO implements DAO {

	private StudentVO makeStudentVO(ResultSet rs) throws SQLException {
		StudentVO student = new StudentVO(rs.getInt("student_id"), rs.getString("sname"), rs.getInt("major_id"),
				rs.getString("phone"), rs.getString("address"), rs.getString("hobby"), rs.getString("skill"));

		return student;
	}

	public List<VO> selectAll() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		StudentVO bd = null;
		List<VO> BDList = new ArrayList<>();
		String sql = "select * from student order by student_id";
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

	public StudentVO selectById(int no) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		StudentVO bd = null;
		String sql = "select * from student where student_id=" + no;
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
				String sql = " insert into student values(" + s.getStudentId() + ", '" + s.getName() + "',"
						+ s.getMajor_id() + ", '" + s.getPhone() + "', '" + s.getAddress() + "', '" + s.getHobby()
						+ "', '" + s.getSkill() + "')";
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
		String sql = " insert into student values( ?,?,?,?,?,?,?)";

		try {
			st = conn.prepareStatement(sql);
			StudentVO s = (StudentVO) vo;
			st.setInt(1, s.getStudentId());
			st.setString(2, s.getName());
			st.setInt(3, s.getMajor_id());
			st.setString(4, s.getPhone());
			st.setString(5, s.getAddress());
			st.setString(6, s.getHobby());
			st.setString(7, s.getSkill());
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
		String sql = "update student set sname=?, major_id =?, phone=?, address=?, hobby=?, skill=? where student_id=?";
		conn = OracleDBUtil.dbConnect();
		try {
			StudentVO s = (StudentVO) vo;
			st = conn.prepareStatement(sql);
			st.setString(1, s.getName());
			st.setInt(2, s.getMajor_id());
			st.setString(3, s.getPhone());
			st.setString(4, s.getAddress());
			st.setString(5, s.getHobby());
			st.setString(6, s.getSkill());
			st.setInt(7, s.getStudentId());
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
