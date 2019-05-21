package com.encore.frontPattern;

import java.io.IOException;
import java.util.HashMap;
import java.util.Map;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
/* http://localhost:9090/education/emp/emplist.go 
 * 
 */

import com.encore.model.EmpVO;
import com.encore.util.EmpUtil;

@WebServlet("*.go")
public class FrontController extends HttpServlet {
	private static final long serialVersionUID = 1L;

	protected void service(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		String uri = request.getRequestURI();/// education/emp/emplist.go
		String path = request.getContextPath(); // education
		String requestURI = uri.substring(path.length(), uri.length() - 3);
		System.out.println(requestURI);
		CommonController controller = null;
		Map<String, Object> data = new HashMap<>();
		String page = null;
		String method = request.getMethod().toLowerCase();
		data.put("method", method);
		System.out.println(method);

		switch (requestURI) {
		case "/emp/emplist":
			controller = new EmpListController();
			page = "emplist.jsp";
			break;
		case "/emp/empInsert":
			controller = new EmpInsertController();
			if (method.equals("get")) {
				System.out.println("get - insert");
				page = "empInsert.jsp";
			} else {
				data.put("emp", EmpUtil.makeEmp(request));
				page = "result.jsp";
			}
			break;
		case "/emp/empDelete":
			controller = new EmpDeleteController();
			data.put("empid", request.getParameter("empid"));
			page = "result.jsp";
			break;

		case "/emp/empById":
			controller = new EmpUpdateController();
			if (method.equals("get")) {
				data.put("empid", request.getParameter("empid"));
				page = "empDetail.jsp";
			} else {
				EmpVO emp = EmpUtil.makeEmp(request);
				data.put("emp", emp);
				page = "result.jsp";
			}

			break;
		}
		controller.execute(data);
		for (String key : data.keySet()) {
			request.setAttribute(key, data.get(key));
		}
		// response.setCharacterEncoding("utf-8");
		RequestDispatcher rd = request.getRequestDispatcher(page);
		rd.forward(request, response);
	}

}
