package com.encore.controller;

import java.util.Map;

import com.encore.model.DAOService;

import valueObject.MajorVO;
import valueObject.VO;
import valueObject.VOType;

public class InsertMajorController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		DAOService service = new DAOService(VOType.MAJOR);
		VO vo = new MajorVO((String)data.get("majorId"), (String)data.get("majorTitle"));
		int result = service.insert(vo);
		System.out.println(result);
		data.put("result", result>0? "success":"fail");
	}

}
