package com.encore.controller3;

import java.io.IOException;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.model.BookDTO;

/**
 * Servlet implementation class BookServlet
 */
@WebServlet("/1129/bookReg.do")
public class BookServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
 
 
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		
		
		
		/*int a=10;
		System.out.println(a/0);
		*/
		int[] a = new int[3];
		a[3] = 100;
		
		
		String title = request.getParameter("title");
		String author = request.getParameter("author");
		String publisher = request.getParameter("publisher");
		
		BookDTO book = new BookDTO(title, author, publisher);
		request.setAttribute("book", book);
		
		RequestDispatcher rd = request.getRequestDispatcher("bookOutput.jsp");
		rd.forward(request, response);//위임 
		
	}

}





