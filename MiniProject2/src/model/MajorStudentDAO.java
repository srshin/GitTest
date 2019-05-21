package model;

import java.sql.Connection;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import util.OracleDBUtil;
import valueObject.MajorStudentVO;
import valueObject.VO;

public class MajorStudentDAO implements DAO{

	private MajorStudentVO makeMajorStudentVO(ResultSet rs) throws SQLException {
		MajorStudentVO student = new MajorStudentVO(rs.getInt("student_id"), rs.getString("sname"), 
				 rs.getString("skill"), rs.getInt("major_id"), rs.getString("major_title") );

		return student;
	}
	
	@Override
	public List<VO> selectAll() {
		String sql = "select student_id, sname, skill, major_id, major_title from student join major using (major_id)";
		return jointSelectAll(sql);
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
	public VO selectById(int no) {
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


}
