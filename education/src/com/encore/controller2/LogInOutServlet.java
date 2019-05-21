package com.encore.controller2;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class LogInOutServlet
 */
@WebServlet("/login/logProc")
public class LogInOutServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public LogInOutServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//logout
		
		HttpSession session = request.getSession(false);
		if(session !=null && session.getAttribute("id") != null) {
			session.invalidate();
			request.setAttribute("message", "로그아웃되었습니다.");
		}else {
			request.setAttribute("message", "로그인 상태가 아닙니다.");
		}
		RequestDispatcher rd;
		rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);
		
		
		
		
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//Login
		request.setCharacterEncoding("utf-8");
		String id = request.getParameter("id");
		String pwd = request.getParameter("pwd");
		HttpSession session = request.getSession();
		if(session.isNew() || session.getAttribute("id")==null) {
			session.setAttribute("id", id);
			session.setAttribute("pwd", pwd);
			request.setAttribute("message", "로그인 완료");
		}else {
			request.setAttribute("message", "이미 로그인");
		}
		/*RequestDispatcher rd;
		rd = request.getRequestDispatcher("result.jsp");
		rd.forward(request, response);*/ 
		
		response.sendRedirect("../emp/emplist");
		
	}

}










