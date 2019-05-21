package controller;

import java.io.IOException;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import model.BoardDAO;
import model.BoardVO;

/**
 * Servlet implementation class SelectByIdServlet
 */
@WebServlet("/board/boardInsert")
public class BoardInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		request.getRequestDispatcher("boardInsert.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO(); 
		
		request.setCharacterEncoding("utf-8");
		BoardVO vo = new BoardVO(0, 
				request.getParameter("title"),
				request.getParameter("contents"),
				request.getParameter("writer"),
				null,
				0);
		System.out.println(vo);
		int result = dao.insertBD(vo);
		if (result > 0) {
			request.setAttribute("message", "성공");
		} else {
			request.setAttribute("message", "실패");
		}
		request.getRequestDispatcher("boardResult.jsp").forward(request, response);

	}

}
