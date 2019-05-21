package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.OracleDBUtil;
import valueObject.MajorVO;
import valueObject.VO;

public class MajorDAO implements DAO{

	private MajorVO makeMajorVO(ResultSet rs) throws SQLException {
		MajorVO bd = new MajorVO(rs.getInt("major_id"), rs.getString("major_title"));

		return bd;
	}

	public List<VO> selectAll() {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		MajorVO bd = null;
		List<VO> list = new ArrayList<>();
		String sql = "select * from major order by major_id";
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				bd = makeMajorVO(rs);
				list.add(bd);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}

		return list;
	}

	public MajorVO selectById(int no) {
		Connection conn = null;
		Statement st = null;
		ResultSet rs = null;
		MajorVO bd = null;
		String sql = "select * from major where major_id=" + no;
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			if (rs.next()) {
				bd = makeMajorVO(rs);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		return bd;
	}

	public int insert(MajorVO vo) {
		Connection conn = null;
		int result = 0;
		PreparedStatement st = null;
		String sql = "insert into major values(?, ?)";
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setInt(1, vo.getMajorId());
			st.setString(2, vo.getMajorTitle());

			result = st.executeUpdate();
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println(e.getMessage());
		} finally {
			OracleDBUtil.dbDisconnect(null, st, conn);
		}
		return result;
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
				MajorVO s = (MajorVO) vo;
				String sql = " insert into major values(" + s.getMajorId() + ", '" + s.getMajorTitle() + "')";
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
		String sql = " insert into major values(?, ?)";
		try {
			st = conn.prepareStatement(sql);
			MajorVO s = (MajorVO) vo;
			st.setInt(1, s.getMajorId());
			st.setString(2, s.getMajorTitle());

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
		String sql = "delete from major where major_id=?";
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
		String sql = "update major set major_title=? where major_id=?";
		conn = OracleDBUtil.dbConnect();
		try {
			MajorVO s = (MajorVO) vo;
			st = conn.prepareStatement(sql);
			st.setString(1, s.getMajorTitle());
			st.setInt(2, s.getMajorId());

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
