<%@page import="com.encore.model.EmpDAO"%>
<%@page import="com.encore.model.EmpVO"%>
<%@page import="com.encore.util.EmpUtil"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
    
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%
	String param = request.getParameter("param");
System.out.print(param);
EmpVO emp = EmpUtil.makeEmp( request);

EmpDAO dao = new EmpDAO();
pageContext.setAttribute("emp", emp);
pageContext.setAttribute("message", dao.insertEmp(emp));
%>
</head>
<body>
<h1>저장 결과</h1>
<%-- <p>${emp }</p> --%>
<p>${message }</p>
직원번호 : ${emp.employee_id}<br>
이름 : ${emp.first_name}<br>
성 : ${emp.last_name}<br>
이메일 :${emp.email}<br>
전화번호 : ${emp.phone_number}<br>
커미션 : ${emp.commission_pct}<br>
부서번호 : ${emp.department_id}<br>
직책 : ${emp.job_id}<br>
입사일 : ${emp.hire_date}<br>
급여 : ${emp.salary}<br>
메니져 : ${emp.manager_id}<br>



</body>
</html>