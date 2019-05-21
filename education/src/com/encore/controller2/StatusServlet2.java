package com.encore.controller2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.encore.model.EmpVO;

/**
 * Servlet implementation class StatusServlet
 */
@WebServlet("/status/info2")
public class StatusServlet2 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext app = this.getServletContext();
		HttpSession session = request.getSession();
		
		EmpVO emp = (EmpVO)session.getAttribute("empdata");
		
		System.out.println(emp);
		
		
	}

	 
}




