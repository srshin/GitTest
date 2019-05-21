package model;

import java.util.List;

public class EmpServiceMySQL {
	MySQLDAO  dao = new MySQLDAO(); 
	public List<MySQLVO> selectAll(int limit) {
		return dao.selectAll(limit);
	}
}
