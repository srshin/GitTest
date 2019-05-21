package com.encore.controller;

import java.util.Map;

import com.encore.model.DAOService;

import valueObject.VO;
import valueObject.VOType;

public class InsertStudentController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		DAOService service = new DAOService(VOType.STUDENT);
		VO vo = (VO)data.get("vo");
		int result = service.insert(vo);
		System.out.println(result);
		data.put("result", result>0? "success":"fail");

	}

}
