package com.encore.controller;

import java.util.Map;

import com.encore.model.DAOService;

import valueObject.VO;
import valueObject.VOType;

public class SelectMajorByIdController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		DAOService service = new DAOService(VOType.MAJOR);
		VO vo = service.selectById((String)data.get("majorId"));
		data.put("vo", vo);
	}

}
