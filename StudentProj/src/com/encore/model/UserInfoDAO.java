package com.encore.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.List;

import com.encore.util.OracleDBUtil;

import valueObject.UserInfoVO;
import valueObject.VO;

public class UserInfoDAO implements DAO {

	@Override
	public List<VO> selectAll() {
		
		return null;
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
		Connection conn = null;
		PreparedStatement st = null;
		ResultSet rs = null;
		VO vo = null; 
		String sql = "select * from userinfo where userid = ? and userpwd = ?";
		conn = OracleDBUtil.dbConnect();
		try {
			st = conn.prepareStatement(sql);
			st.setString(1, userid);
			st.setString(2, userpass);
			rs = st.executeQuery();
			System.out.println(userid);
			System.out.println(userpass);
			if(rs.next())	vo = new UserInfoVO(rs.getString("userid"), rs.getString("userpwd"));
			System.out.println(vo);
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			OracleDBUtil.dbDisconnect(rs, st, conn);
		}
		return vo;

		
	}

	@Override
	public int deleteAll() {
		// TODO Auto-generated method stub
		return 0;
	}

}
