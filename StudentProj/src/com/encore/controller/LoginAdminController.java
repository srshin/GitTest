package com.encore.controller;

import java.util.Map;

import com.encore.model.DAOService;


import valueObject.VO;
import valueObject.VOType;

public class LoginAdminController implements CommonController {

	@Override
	public void execute(Map<String, Object> data) {
		String userid = (String) data.get("userId");
		String userpass = (String) data.get("userPassword");
		DAOService service = new DAOService(VOType.USER_INFO);
		
		VO vo =service.loginCheck(userid, userpass);
		System.out.println(vo);
		data.put("loginAdmin", vo);
	}

}
