package com.encore.controller;

import java.util.Map;

import com.encore.model.DAOService;

import valueObject.VOType;

public class DbSaveMajorStudentController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		data.put("result", "요청한 작업이 수행되지 않았습니다. ");
		DAOService studentService = new DAOService(VOType.STUDENT);
		int result = studentService.deleteAll();
		System.out.println("result0 "+result);
		if (result<0 ) return; 

		DAOService majorService = new DAOService(VOType.MAJOR);
		result = majorService.deleteAll();
		System.out.println("result1 "+result);
		if (result<0 ) return; 

		String majorPath = (String) data.get("majorPath");
		result = majorService.insertFileTable(VOType.MAJOR, majorPath);
		System.out.println("result2 "+result);
		if (result<=0 ) return; 

		String studentPath = (String) data.get("studentPath");
		result = studentService.insertFileTable(VOType.STUDENT, studentPath);
		System.out.println("result3 "+result);
		if (result<=0 ) return; 
		
		System.out.println("result "+result);
		data.put("result", "요청한 작업이 성공하였습니다. ");
		
	}

}
