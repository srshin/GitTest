package com.encore.controller;

import java.util.Map;

import com.encore.model.DAOService;

import valueObject.VOType;

public class SelectStudentController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		DAOService service = new DAOService(VOType.MAJOR_STUDENT);
		System.out.println(service.selectAll());
		data.put("studentList", service.selectAll());

	}

}
