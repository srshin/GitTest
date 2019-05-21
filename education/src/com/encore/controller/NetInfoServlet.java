package com.encore.controller;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.Enumeration;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
 
@WebServlet("/netinfo")
public class NetInfoServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		response.setContentType("text/html;charset=UTF-8");
		PrintWriter out = response.getWriter();
		out.println("<h1>요청정보 알아보기 </h1>");
		out.println("getScheme:" + request.getScheme() + "<br>");
		out.println("getServerName:" + request.getServerName() + "<br>");
		out.println("getLocalAddr:" + request.getLocalAddr() + "<br>");
		out.println("getServerPort:" + request.getServerPort() + "<br>");
		out.println("getRemoteAddr:" + request.getRemoteAddr() + "<br>");
		out.println("getRemoteHost:" + request.getRemoteHost() + "<br>");
		out.println("getRemotePort:" + request.getRemotePort() + "<br>");
		out.println("getServletContext:" + request.getServletContext() + "<br>");
		out.println("getMethod:" + request.getMethod() + "<br>");
		out.println("getQueryString:" + request.getQueryString() + "<br>");
		out.println("getRequestURI:" + request.getRequestURI() + "<br>");
		out.println("getRequestURL:" + request.getRequestURL() + "<br>");
		out.println("getContextPath:" + request.getContextPath() + "<br>");
		out.println("getServletPath:" + request.getServletPath() + "<br>");
		
		//Header정보 얻기 
		out.println("Accept-Language:" + request.getHeader("Accept-Language") + "<br>");
	
	    Enumeration<String> hs = request.getHeaderNames();
	    while(hs.hasMoreElements()) {
	    	String h = hs.nextElement();
	    	out.println(h + "-->" + request.getHeader(h) + "<br>");
	    }
	
	}

	 

}
