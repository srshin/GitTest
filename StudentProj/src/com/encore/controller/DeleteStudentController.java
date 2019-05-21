package com.encore.controller;

import java.util.Map;

import com.encore.model.DAOService;

import valueObject.VOType;

public class DeleteStudentController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		DAOService service = new DAOService(VOType.STUDENT);
		int studentId = Integer.valueOf((String)data.get("studentId"));
		int result = service.delete(studentId);
		System.out.println(result);
		data.put("result", result>0? "success":"fail");

	}

}
