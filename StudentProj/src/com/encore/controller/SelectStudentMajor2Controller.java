package com.encore.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.encore.model.DAOService;

import valueObject.VO;
import valueObject.VOType;

public class SelectStudentMajor2Controller implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		DAOService service = new DAOService(VOType.MAJOR_STUDENT);
		Map<String, String> cond = new HashMap<>();
		String majorId=(String)data.get("majorId");
		String studentId=(String)data.get("studentId");
		String name=(String)data.get("name");
		System.out.println(majorId);
		if(!majorId.equals("all")) cond.put("major_id = ", majorId);
		if(!studentId.equals("all")) cond.put("student_id = ",studentId );
		if(!name.equals("")) cond.put("sname like ", "'%"+ name+"%'");
		
		List<VO> list= service.jointSelectAll(cond);
		data.put("studentMajorList", list);
		
;

	}

}
