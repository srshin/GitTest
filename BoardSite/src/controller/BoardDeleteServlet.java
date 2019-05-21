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
@WebServlet("/board/boardDelete")
public class BoardDeleteServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO(); 
		
		int result = dao.deleteBD(Integer.parseInt(request.getParameter("bno")));
		if (result >0 )
			request.setAttribute("message", result + "삭제 성공하였습니다. ");
		else 
			request.setAttribute("message", result + "삭제 실패하였습니다. ");
	
		request.getRequestDispatcher("boardResult.jsp").forward(request, response);
	}

	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardDAO dao = new BoardDAO(); 
		
	}

}
