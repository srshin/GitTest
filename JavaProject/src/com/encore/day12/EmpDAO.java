package com.encore.day12;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class EmpDAO {
	final static int EMP_ID = 0;
	final static int FIRST_NAME = 1;
	final static int LAST_NAME = 2;
	final static int EMAIL = 3;
	final static int PHONE_NUMBER = 4;
	final static int YEAR = 5;
	final static int JOB_ID = 6;
	final static int SALARY = 7;
	final static int COMMISION = 8;
	final static int MANAGER_ID = 9;
	final static int DEPT_ID =10 ;
	
	public List<EmpDTO> selectAll() throws IOException {
		return collect(); 
	}
	public EmpDTO selectById(int emp_id) throws IOException {
		List<EmpDTO> emplist = collect();
		for (EmpDTO dto : emplist) {
			if (dto.getElement(EMP_ID).equals(Integer.toString(emp_id))) {
				return dto; 
			}
		}
		return null;  
	}
	
	private List<EmpDTO> collect() throws IOException {
		List<EmpDTO> list = new ArrayList<>();
		BufferedReader br = new BufferedReader(new FileReader("src/com/encore/day12/emp.csv"));
		String str;
		while( (str=br.readLine())!=null) {
			list.add(new EmpDTO(str.split(",")));
		}
		if (br!=null) br.close();
		return list; 
		
	}
	public List<EmpDTO> selectBySalary(int select, int i) throws IOException {
		List<EmpDTO> list = collect();
		List<EmpDTO> retList = new ArrayList<>();
		for (EmpDTO  dto: list) {
			try {
				if (Integer.parseInt(dto.getElement(select)) >= i)  retList.add(dto);
			} catch (Exception e)  {
				retList.add(dto);
			}
		}
		return retList; 
	}
	public List<EmpDTO> selectByDept(int select,  String dep) throws IOException {
		List<EmpDTO> list = collect();
		List<EmpDTO> retList = new ArrayList<>();
		retList.add(list.get(0));
		for (EmpDTO  dto: list) {
			try {
				if (dto.getElement(select).equals(dep))  retList.add(dto);
			} catch (Exception e)  {
				retList.add(dto);
			}
		}
		return retList; 
	}
	public void menuList(int deptId) throws IOException {
		Map<String, Integer> map = new HashMap<>();
		List<EmpDTO> list = collect();
		for (EmpDTO dto: list) {
			if (map.containsKey(dto.getElement(deptId))) {
				map.put(dto.getElement(deptId), map.get(dto.getElement(deptId))+1);
			} else {
				map.put(dto.getElement(deptId), 1);
			}
		}
		for (String key: map.keySet())  System.out.print(key+"("+map.get(key)+")"+"/");
		System.out.println();
	}
	
}
