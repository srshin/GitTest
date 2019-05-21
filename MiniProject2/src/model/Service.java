package model;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import valueObject.MajorVO;
import valueObject.StudentVO;
import valueObject.VO;
import valueObject.VOType;

//business logic
public class Service {
	Map<VOType, DAO> map;
	
	public Service()
	{
		super();
		map = new HashMap<VOType, DAO>();
	}
	
	public void start(VOType voType) {
		if (voType==VOType.STUDENT)				map.put(voType, new StudentDAO());
		else if (voType==VOType.MAJOR)			map.put(voType, new MajorDAO());
		else if (voType==VOType.MAJOR_STUDENT)	map.put(voType, new MajorStudentDAO());
	}

	private int insertAll(List<VO> list, VOType voType) {
		if (list.size() == 0) return 0;
		return map.get(voType).insertAll(list);
	}
	
	private List<VO> readFromCSV(VOType voType) {
		List<VO> list = new ArrayList<>();
		try (BufferedReader br = new BufferedReader(new InputStreamReader(new FileInputStream(voType.getFile()), "euc-kr"));){
			
			String line;
			br.readLine(); // 컬럼 제목 부분 버리기
			while (true) {
				line = br.readLine();
				if (line == null)  break;
				String[] data = line.split(",", 7);
				if (voType==VOType.MAJOR) {
					VO major = new MajorVO(Integer.parseInt(data[0]), data[1]);
					list.add(major);
				} else if (voType==VOType.STUDENT) {
					VO student = new StudentVO(Integer.parseInt(data[0]), data[1], Integer.parseInt(data[2]),
							data[3], data[4], data[5], data[6]);
					list.add(student);
				}
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return list;
	}
	
	public int createTable(VOType voType) {
		List<VO> list = readFromCSV(voType);
		return insertAll(list, voType);
	}
	
	public List<VO> selectAll(VOType voType) {
		return map.get(voType).selectAll();
	}

	public VO selectById(int no, VOType voType) {
		return map.get(voType).selectById(no);
	}
	public int insert(VO vo, VOType voType) {
		return map.get(voType).insert(vo);
	}

	public int delete(int no, VOType voType) {
		return map.get(voType).delete(no);
	}

	public int update(VO vo, VOType voType) {
		return map.get(voType).update(vo);
	}

	public List<VO> jointSelectAll(Map<String, String> cond) {
		String sql = "select student_id, sname, skill, major_id, major_title from student join major using (major_id) where 1=1 ";
			for(String key : cond.keySet()) {
				sql += " and " +  key + " like" +  " '%" + cond.get(key) +"%'" ;
			}
			System.out.println(sql);
		return ((MajorStudentDAO) map.get(VOType.MAJOR_STUDENT)).jointSelectAll(sql);
	}
}
