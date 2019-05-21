package com.encore.controller4;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.model.BoardManager;
import com.encore.model.BoardVO;

/**
 * Servlet implementation class BoardServlet
 */
@WebServlet("/1130/boardList")
public class BoardServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public BoardServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		BoardManager manager = new BoardManager();
		List<BoardVO> list = manager.getBoardList();
		request.setAttribute("blist", list);
		
		RequestDispatcher rd = 
				request.getRequestDispatcher("boardOutput.jsp");
		rd.forward(request, response);
	}

}





