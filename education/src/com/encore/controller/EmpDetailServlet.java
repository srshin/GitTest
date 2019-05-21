package com.encore.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.encore.model.DeptDTO;
import com.encore.model.EmpService;
import com.encore.model.EmpVO;
import com.encore.util.EmpUtil;

/**
 * Servlet implementation class EmpDetailServlet
 */
//@WebServlet("/emp/empById")
public class EmpDetailServlet extends HttpServlet {
	private static final long serialVersionUID = 1L;
       
    /**
     * @see HttpServlet#HttpServlet()
     */
    public EmpDetailServlet() {
        super();
        // TODO Auto-generated constructor stub
    }

	/**
	 * @see HttpServlet#doGet(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doGet(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doGet");
		String sid = request.getParameter("empid");
		int empid = Integer.parseInt(sid);
		System.out.println(empid);
		
		EmpService service = new EmpService();
		List<DeptDTO> list = service.selectAllDept();
		System.out.println(list);
		request.setAttribute("dList", service.selectAllDept());
		request.setAttribute("jList", service.selectAllJob());
		request.setAttribute("mList", service.selectAllManager());
		EmpVO empvo = service.selectById(empid);
		System.out.println(empvo);
		request.setAttribute("emp", empvo);
	
		RequestDispatcher rd = request.getRequestDispatcher("empDetail.jsp");
		rd.forward(request, response);
	}

	/**
	 * @see HttpServlet#doPost(HttpServletRequest request, HttpServletResponse response)
	 */
	protected void doPost(HttpServletRequest request, HttpServletResponse response) throws ServletException, IOException {
		System.out.println("doPost");
		EmpVO emp = EmpUtil.makeEmp(request);
		EmpService service = new EmpService();
		int result = service.updateEmp(emp);
		System.out.println(result +"수정");
		request.setAttribute("emp", emp);
		if (result >0) {
			request.setAttribute("message", result + "건 수정성공");
		} else {
			request.setAttribute("message", "수정실패");
		}
		request.getRequestDispatcher("result.jsp").forward(request, response);
		//
		//response.sendRedirect("emplist.jsp");

	}




}
