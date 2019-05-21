package com.encore.controller;

import java.util.Map;

import com.encore.model.DAOService;
import valueObject.VOType;

public class DeleteMajorController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		DAOService service = new DAOService(VOType.MAJOR);
		int majorId = Integer.valueOf((String)data.get("majorId"));
		int result = service.delete(majorId);
		System.out.println(result);
		data.put("result", result>0? "success":"fail");

	}

}
