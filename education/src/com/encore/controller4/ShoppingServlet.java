package com.encore.controller4;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

/**
 * Servlet implementation class ShoppingServlet
 */
@WebServlet("/1130/shopping")
public class ShoppingServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		HttpSession session = request.getSession(false);
		if(session!=null) {
			session.removeAttribute("cart");
		}
		
		response.sendRedirect("input.jsp");
		
	}
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
	   //장바구니 담은 정보 
	   String fruitName = request.getParameter("fruitName");
	   String scount = request.getParameter("count");
	   int count = 0;
	   if(scount!="" && scount != null) count = Integer.parseInt(scount);
	   //session에서 찾기
	   HttpSession session = request.getSession();
	   Map<String, Integer> cart = null;
	   Object obj = session.getAttribute("cart");
	   if(obj == null) 
		   cart = new HashMap<>();   
	   else
		   cart = (Map<String, Integer>)obj;
	   	   
	   if(cart.containsKey(fruitName)) {
		  cart.put(fruitName, cart.get(fruitName) + count);
	   }else {
		  cart.put(fruitName, count ); 
	   }
	   //결과를 세션에 저장
	   session.setAttribute("cart", cart);	   
 
   
	   //결과화면 보이기 	
	   RequestDispatcher rd = request.getRequestDispatcher("output.jsp");
	   rd.forward(request, response);
	
	}

}
