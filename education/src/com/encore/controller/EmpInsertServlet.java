package com.encore.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.model.DeptDTO;
import com.encore.model.EmpService;
import com.encore.model.EmpVO;
import com.encore.util.EmpUtil;

/**
 * Servlet implementation class EmpInsertServlet
 */
//@WebServlet("/emp/empInsert")
public class EmpInsertServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpInsertServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		//부서 데이타
		//직책 데이타 보여주기 
		//입력 form보여주기 
		EmpService service = new EmpService();
		List<DeptDTO> list = service.selectAllDept();
		System.out.println(list);
		request.setAttribute("dList", service.selectAllDept());
		request.setAttribute("jList", service.selectAllJob());
		request.setAttribute("mList", service.selectAllManager());
		
		
		request.getRequestDispatcher("empInsert.jsp").forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		// DB에 입력하기 
		EmpVO emp = EmpUtil.makeEmp(request);
		EmpService service = new EmpService();
		int result = service.insertEmp(emp);
		System.out.println(result +"입력");
		request.setAttribute("emp", emp);
		if (result >0) {
			request.setAttribute("message", result + "건 입력 성공");
		} else {
			request.setAttribute("message", "입력 실패");
		}
		request.getRequestDispatcher("result.jsp").forward(request, response);
		//
		//response.sendRedirect("emplist.jsp");
	}

}
