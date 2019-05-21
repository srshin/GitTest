package com.encore.controller;

import java.util.Map;

import com.encore.model.DAOService;

import valueObject.VO;
import valueObject.VOType;

public class SelectStudentByIdController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		DAOService service = new DAOService(VOType.STUDENT);
		VO vo = service.selectById((String)data.get("studentId"));
		data.put("vo", vo);
		data.put("majorList", new DAOService(VOType.MAJOR).selectAll());
	}

}
