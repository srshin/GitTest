package com.encore.controller;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.encore.model.DAOService;

import valueObject.StudentVO;
import valueObject.VO;
import valueObject.VOType;

@WebServlet("*.do")
public class MainFrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		HttpSession session = request.getSession();

		request.setCharacterEncoding("utf-8");
		String uri = request.getRequestURI();/// education/emp/emplist.go
		String path = request.getContextPath();
		String requestURI = uri.substring(path.length(), uri.length() - 3);
		CommonController controller = null;
		Map<String, Object> data = new HashMap<>();
		String method = request.getMethod().toLowerCase();
		String page = null;
		
		Object sessionObj = session.getAttribute("admin");
		Object sessionObj2 = session.getAttribute("student");
		if (sessionObj==null && requestURI.contains("/admin"))  {
			response.sendRedirect(path+"/index.jsp");
			return; 
		}
		System.out.println(sessionObj2);
		System.out.println("requestURI : "+requestURI);
		if (sessionObj2==null && requestURI.contains("/student"))  {
			response.sendRedirect(path+"/index.jsp");
			return; 
		}
		

		switch (requestURI) {
		case "/login":
			data.put("userId", request.getParameter("userId"));
			data.put("userPassword", request.getParameter("userPassword"));
			data.put("message", "로그인정보가 정확하지 않습니다");
			page = "index.jsp";
			controller = new LoginAdminController();
			controller.execute(data);
			if (data.get("loginAdmin") != null) {
				session.setAttribute("admin", data.get("loginAdmin"));
				page = "/admin/indexAdmin.jsp";
			} else {
				controller = new LoginStudentController(); 
				controller.execute(data);
				if (data.get("loginStudent") != null) {
					session.setAttribute("student", data.get("loginStudent"));
					page = "/student/indexStudent.jsp";
				}
			}
			break;
		case "/admin/dbSaveMajorStudent": // major.csv DB저장
			System.out.println("IN");
			controller = new DbSaveMajorStudentController();
			String filePath = request.getServletContext().getRealPath("csvFile");
			data.put("majorPath", filePath + "/major.csv");
			data.put("studentPath", filePath + "/student.csv");
			controller.execute(data);
			page = "result.jsp";
			break;
		case "/admin/insertMajor": // major 등록
			System.out.println(method);
			if (method.equals("get")) {
				page = "insertMajor.jsp";
			} else {
				controller = new InsertMajorController();
				data.put("majorId", request.getParameter("majorId"));
				data.put("majorTitle", request.getParameter("majorTitle"));
				controller.execute(data);
				page = "result.jsp";
			}
			break;
		case "/admin/selectMajor": // major 조회/수정/삭제
			controller = new SelectMajorController();
			controller.execute(data);
			page = "listMajor.jsp";
			break;
		case "/admin/selectById": // 조회
			controller = new SelectMajorByIdController();
			data.put("majorId", request.getParameter("majorId"));
			controller.execute(data);
			page = "updateMajor.jsp";
			break;
		case "/admin/updateMajor": // 수정
			controller = new UpdateMajorController();
			data.put("majorId", request.getParameter("majorId"));
			data.put("majorTitle", request.getParameter("majorTitle"));
			controller.execute(data);
			page = "result.jsp";
			break;
		case "/admin/deleteMajor": // 삭제
			controller = new DeleteMajorController();
			data.put("majorId", request.getParameter("majorId"));
			controller.execute(data);
			page = "result.jsp";
			break;
		case "/admin/insertStudent": // student 등록
			if (method.equals("get")) {
				data.put("majorList", new DAOService(VOType.MAJOR).selectAll());
				page = "insertStudent.jsp";
			} else {
				controller = new InsertStudentController();
				VO vo = new StudentVO(
				request.getParameter("studentId"),
				request.getParameter("password"),
				request.getParameter("name"),
				request.getParameter("majorId"),
				request.getParameter("phone"),
				request.getParameter("address"),
				request.getParameter("hobby"),
				request.getParameter("skill"));
				data.put("vo", vo);
				controller.execute(data);
				page = "result.jsp";
			}
			break;
		case "/admin/selectStudent": // student 조회/수정.삭제
			controller = new SelectStudentController();
			controller.execute(data);
			page = "listStudent.jsp";
			break;
		case "/admin/selectStudentById": // 조회
			controller = new SelectStudentByIdController();
			data.put("studentId", request.getParameter("studentId"));
			controller.execute(data);
			page = "updateStudent.jsp";
			break;
		case "/admin/updateStudent": // 수정
		case "/student/updateStudent" :
			controller = new UpdateStudentController();
			System.out.println("phone"+ request.getParameter("phone"));
			
			VO vo = new StudentVO(
			request.getParameter("studentId"),
			request.getParameter("password"),
			request.getParameter("name"),
			request.getParameter("majorId"),
			request.getParameter("phone"),
			request.getParameter("address"),
			request.getParameter("hobby"),
			request.getParameter("skill"));
			data.put("vo", vo);
			controller.execute(data);
			page = "result.jsp";
			break;
		case "/admin/deleteStudent": // 삭제
			controller = new DeleteStudentController();
			data.put("studentId", request.getParameter("studentId"));
			controller.execute(data);
			page = "result.jsp";
			break;
		case "/student/selectStudentMajor": //조회 
			controller = new SelectStudentMajorController(); 
			controller.execute(data);
			page="listStudentMajor.jsp";
			break;
		case "/student/selectStudentMajor2": //조회 
			System.out.println("/student/selectStudentMajor2로 인!");
			
			controller = new SelectStudentMajor2Controller(); 
			data.put("majorId", request.getParameter("majorId"));
			data.put("studentId", request.getParameter("studentId"));
			data.put("name", request.getParameter("name"));
			
			controller.execute(data);
			page="listStudentMajor2.jsp";
			break;
			
		case"/student/SelectByStudentId": 
			page = "updateStudent.jsp";
			break;
		default:
			System.out.println("URI error발견");
			System.exit(0);
			break;
		}
		for (String key : data.keySet()) {
			request.setAttribute(key, data.get(key));
		}
		request.getRequestDispatcher(page).forward(request, response);
	}

}
