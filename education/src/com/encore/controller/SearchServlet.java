package com.encore.controller;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SearchServlet
 */
@WebServlet("/naver/find")
public class SearchServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;

 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		String str = request.getParameter("search");
		System.out.println(str);
		request.setAttribute("data", "검색한 내용입니다.");
		String[] data2 = {"사과","귤","감"};
		request.setAttribute("data2", data2);
		request.setAttribute("data3", str);
		RequestDispatcher rd = request.getRequestDispatcher("output.jsp");
		//rd.forward(request, response);
		response.setCharacterEncoding("utf-8");
		rd.include(request, response);
		
	}

}
