package com.encore.controller3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

 
@WebServlet("/1129/vendingMachine")
public class VendingMachineServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//파라메타 받기
		String[] items = request.getParameterValues("item");
		String sprice = request.getParameter("price");
		int iprice = Integer.parseInt(sprice);		
		//로직수행
		int sum=0;
		for(String item:items) {
			int a = item.indexOf('(');
			int b = item.indexOf('원');
			int p = Integer.parseInt(item.substring(a+1, b));
			sum += p;
		}
		//데이터를 저장
		request.setAttribute("change", iprice - sum);
		request.setAttribute("items", items);
		//jsp로 forward 
		RequestDispatcher rd = request.getRequestDispatcher("output.jsp");
		rd.forward(request, response);
	}

	 
}
