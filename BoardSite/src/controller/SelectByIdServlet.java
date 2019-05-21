package controller;

import java.io.IOException;
import java.sql.Date;

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
@WebServlet("/board/selectById")
public class SelectByIdServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO(); 
		
		BoardVO board = dao.selectById(Integer.parseInt(request.getParameter("bno")));
		System.out.println(board);
		request.setAttribute("board", board);
	
		request.getRequestDispatcher("boardView.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO(); 
		
		request.setCharacterEncoding("utf-8");
		BoardVO vo = new BoardVO(Integer.valueOf(request.getParameter("bno")), 
				request.getParameter("title"),
				request.getParameter("contents"),
				request.getParameter("writer"),
				Date.valueOf(request.getParameter("regdate")),
				Integer.valueOf(request.getParameter("count")));
		System.out.println(vo);
		int result = dao.updateBD(vo);
		if (result > 0) {
			request.setAttribute("message", "성공");
		} else {
			request.setAttribute("message", "실패");
		}
		request.getRequestDispatcher("boardResult.jsp").forward(request, response);

	}

}
