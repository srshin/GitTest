package com.encore.controller;

import java.io.IOException;
import javax.servlet.ServletConfig;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * Servlet implementation class SecondServlet
 */
@WebServlet(urlPatterns= {"/second", "/second4"})
public class SecondServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
      
	int count=0;
	
    /**
     * @see HttpServlet#HttpServlet()
     */
    public SecondServlet() {
       System.out.println("SecondServlet생성자");
    }

	/**
	 * @see Servlet#init(ServletConfig)
	 */
	public void init(ServletConfig config) throws ServletException {
		System.out.println("SecondServlet init");
	}

	/**
	 * @see Servlet#destroy()
	 */
	public void destroy() {
		System.out.println("SecondServlet destroy");
	}

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void service(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		int i=0;
		i++;
		count++;
		System.out.println("SecondServlet doGet:" + count);
		response.getWriter().append("Served at: "+i + ":" + count).append(request.getContextPath());
	}

	

}
