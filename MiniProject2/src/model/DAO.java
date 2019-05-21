package model;

import java.util.List;

import valueObject.VO;

public interface DAO {

	public abstract List<VO> selectAll();
	public abstract int insertAll(List<VO> list);
	public abstract VO selectById(int no);
	public abstract int insert(VO vo);  
	public abstract  int delete(int no);
	public abstract int update(VO vo);
}
