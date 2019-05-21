package com.encore.model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import valueObject.MajorVO;
import valueObject.StudentVO;
import valueObject.VO;
import valueObject.VOType;

//business logic
public class DAOService {
	DAO dao=null;
	
	public DAOService(VOType voType)
	{
		super();
		switch(voType) {
		case STUDENT:	dao= new StudentDAO(); break;
		case MAJOR:		dao = new MajorDAO(); break;
		case MAJOR_STUDENT: 	dao = new MajorStudentDAO(); break;
		case USER_INFO : dao =  new UserInfoDAO(); break;
		}
	}

	private int insertAll(List<VO> list) {
		if (list.size() == 0) return 0;
		return dao.insertAll(list);
	}
	
	private List<VO> readFromCSV(VOType voType, String path) {
		List<VO> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(path), "euc-kr"));){
			
			String line;
			br.readLine(); // 컬럼 제목 부분 버리기
			while (true) {
				line = br.readLine();
				if (line == null)  break;
				String[] data = line.split(",", 8);
				if (voType==VOType.MAJOR) {
					VO major = new MajorVO(data[0], data[1]);
					list.add(major);
					System.out.println(major);
				} else if (voType==VOType.STUDENT) {
					VO student = new StudentVO(data[0], data[1], data[2],
							data[3], data[4], data[5], data[6], data[7]);
					list.add(student);
					System.out.println(student);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int insertFileTable(VOType voType, String path) {
		List<VO> list = readFromCSV(voType, path);
		return insertAll(list);
	}
	public int deleteAll() {
		int result = dao.deleteAll();
		return result; 
	}
	
	public List<VO> selectAll() {
		return dao.selectAll();
	}

	public VO selectById(String no) {
		return dao.selectById(no);
	}
	public int insert(VO vo) {
		return dao.insert(vo);
	}

	public int delete(int no) {
		return dao.delete(no);
	}

	public int update(VO vo) {
		return dao.update(vo);
	}

	public List<VO> jointSelectAll(Map<String, String> cond) {
		String sql = "select student_id, sname, skill, major_id, major_title from student join major using (major_id) where 1=1 ";
			for(String key : cond.keySet()) {
				sql += " and " +  key  + cond.get(key);
			}
			System.out.println(sql);
		return ((MajorStudentDAO) dao).jointSelectAll(sql);
	}

	public VO loginCheck(String userid, String userpass) {
		return dao.loginCheck(userid, userpass);
		
	}
}
