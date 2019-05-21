package com.encore.controller2;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Date;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class SessionServlet2
 */
@WebServlet("/status/ses")
public class SessionServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
     
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String p = request.getParameter("param");
		String msg="";
		HttpSession session = null;
		switch (p) {
		case "create":
			session = request.getSession();
			if(session.isNew()) {
				msg = "session이 신규생성";
			}else {
				msg = "기존 session";
			}
			break;
		case "add":
			session = request.getSession(true);
			session.setAttribute("msg", "세션에 메시지가 등록됨");
			session.setAttribute("age", 100);
			session.setAttribute("today", new Date());
			msg = "세션에 메시지가 등록됨~~~~~~";
			break;
		case "get":
			session = request.getSession(false);
			if(session == null) {
				msg = "session이 없음";
			}else {
				msg = (String)session.getAttribute("msg") + "...추출함";
				
			}
			
			break;
		case "delete":
			session = request.getSession(false);//존재하는 세션얻기
			if(session == null) {
				msg= "세션없음";
			}else {
				//모두지우기 
				session.invalidate();
				msg = "invalidate 이용 모두지움 ";
			}
			break;
		case "remove":
			session = request.getSession(false);//존재하는 세션얻기
			if(session == null) {
				msg= "세션없음";
			}else {
				//특정변수 지우기 
				session.removeAttribute("msg");
				msg = "removeAttribute 이용 모두지움 ";
			}
			break;			
		case "replace":
			session = request.getSession();
			session.setAttribute("msg", "메시지정보 변경");
			msg = "메시지정보 변경 완료";
			break;	
			
		default:
			break;
		}
		response.setContentType("text/html;charset=utf-8");
		PrintWriter out = response.getWriter();
		out.print("<h1>session연습</h1>");
		out.print("<h1>" + msg + "</h1>");
	}

	 

}
