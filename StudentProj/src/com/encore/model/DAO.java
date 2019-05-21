package com.encore.model;

import java.util.List;

import valueObject.VO;


public interface DAO {

	public abstract List<VO> selectAll();
	public abstract int insertAll(List<VO> list);
	public abstract VO selectById(String no);
	public abstract int insert(VO vo);  
	public abstract  int delete(int no);
	public abstract int update(VO vo);
	public abstract VO loginCheck(String userid, String userpass);
	public abstract int deleteAll();

}
