package com.encore.controller;

import java.util.Map;

import com.encore.model.DAOService;

import valueObject.VO;
import valueObject.VOType;

public class UpdateStudentController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		DAOService service = new DAOService(VOType.STUDENT);
		VO vo = (VO) data.get("vo");
		int result = service.update(vo);
		System.out.println(result);
		data.put("result", result>0? "success":"fail");

	}

}
