package model;

import java.util.List;

//business logic
public class BDService {
	BDDAO dao = new BDDAO();
	
	public List<BDVO> selectAll() {
		return dao.selectAll(); 
	}
	
	public BDVO selectById(int bdno) {
		dao.updateBD(bdno); 
		return dao.selectById(bdno); 
	}
	public int insertBD(BDVO bd) {
		return dao.insertBD(bd); 
	}

	public int updateBD(BDVO bd) {
		return dao.updateBD(bd); 
	}
		
	public int deleteBD(int bdno) {
		return dao.deleteBD(bdno); 
	}

}
