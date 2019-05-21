package com.encore.controller4;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class TotalServlet
 */
@WebServlet("/1130/total2")
public class TotalServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(); 
		//session읽기
		Object obj = session.getAttribute("totalPrice");
		int total = 0;
		if(obj != null){
			total = (Integer)obj;
		}
		//parameter읽기
		String item = request.getParameter("item");

		//계산
		//session저장
		int price = 0;
		if("0".equals(item)){
			session.setAttribute("totalPrice",0);
		}else{
			if(item !=null) price = Integer.parseInt(item);
			session.setAttribute("totalPrice", total + price);
		}
		RequestDispatcher rd = request.getRequestDispatcher("total.jsp");
		rd.forward(request, response);
		 
		
	}

}







