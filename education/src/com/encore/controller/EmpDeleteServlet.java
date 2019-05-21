package com.encore.controller;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.model.EmpService;

/**
 * Servlet implementation class EmpDeleteServlet
 */
//@WebServlet("/emp/empDelete")
public class EmpDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String semp_id = request.getParameter("empid");
		int emp_id = Integer.parseInt(semp_id);
		EmpService service = new EmpService();
		int result = service.deleteEmp(emp_id);
		System.out.println(result);
		if (result >0 )
			request.setAttribute("message", result + "삭제 성공하였습니다. ");
		else 
			request.setAttribute("message", result + "삭제 실패하였습니다. ");
	
		request.getRequestDispatcher("result.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
