package com.encore.controller2;

import java.io.IOException;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class CookieServlet
 */
@WebServlet("/cookie3")
public class CookieServlet3 extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public CookieServlet3() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int count=0;
		Cookie[] cs = request.getCookies();
		if(cs!=null) {			 
			for(Cookie c : cs) {
				String name = c.getName();
				if(name.equals("count")) {
					count = Integer.parseInt(c.getValue());
				}
			}
		}		
		Cookie c1 = new Cookie("count", ++count+"");	
		c1.setMaxAge(60*60*24);
		response.addCookie(c1);
		response.setContentType("text/html;charset=utf-8");
		response.getWriter().append("<h1>방문횟수:" + count + "</h1>");
	
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// TODO Auto-generated method stub
		doGet(request, response);
	}

}
