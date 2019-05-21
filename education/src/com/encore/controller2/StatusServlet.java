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
@WebServlet("/status/info")
public class StatusServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		ServletContext app = this.getServletContext();
		HttpSession session = request.getSession();
		
		String name = request.getParameter("name");
		
		app.setAttribute("myname1", name +"....ServletContext");
		session.setAttribute("myname2", name +"....session");
		request.setAttribute("myname3", name +"....request");
	
		EmpVO emp = new EmpVO(100, "정진",
				"커피", "zzilre", null, null, 
				null, 0, 0, 100, 0);
		session.setAttribute("empdata", emp);
		
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
	
	}

	 
}




