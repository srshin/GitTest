<%@page import="com.encore.model.EmpVO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- HTML의 기본경로는 http://ip:port    -->
<!-- 서블릿은 http://ip[:port/educaion  -->
<jsp:include page="/header.jsp"></jsp:include> 



<h1>상태정보 유지기술.....확인</h1>
application : ${myname1 } <br>
session : ${myname2 } <br>
request : ${myname3 } <br>
<h2>직원정보</h2>
<%
	EmpVO emp = (EmpVO)session.getAttribute("empdata");
int id = emp.getEmployee_id();
%>
직원번호 getEmployee_id(): <%=id %> <br>
직원번호 getEmployee_id(): ${empdata.employee_id} <br>
first_name: ${empdata.first_name} <br>
last_name: ${empdata.last_name} <br>
email: ${empdata.email} <br>
             
</body>
</html>