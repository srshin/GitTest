package com.encore.controller;

import java.io.IOException;

import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.*;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/*@WebServlet(urlPatterns= {"/initParam2"}, 
  initParams= { 
		  @WebInitParam(name="userid", value="SCOTT"),
		  @WebInitParam(name="userpass", value="TIGER") 		  
})*/
public class InitParamServlet extends HttpServlet {
	String id, pass;
	public InitParamServlet(){
		System.out.println("InitParamServlet생성자");
	}
	@Override
	protected void service(HttpServletRequest req, 
			               HttpServletResponse rep) throws ServletException, IOException {
		System.out.println("사용자ID:" + id); 
		System.out.println("사용자pass:" + pass);
	}

	@Override
	public void init(ServletConfig config) throws ServletException {
		 System.out.println("InitParamServlet init"); 
		 id = config.getInitParameter("userid");
		 pass = config.getInitParameter("userpass");
	}
	
}






