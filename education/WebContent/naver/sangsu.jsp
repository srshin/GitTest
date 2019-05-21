<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<%
request.setCharacterEncoding("utf-8");
String str = request.getParameter("search");
System.out.println(str);
request.setAttribute("data", "검색한 내용입니다.");
String[] data2 = {"사과","귤","감"};
request.setAttribute("data2", data2);
request.setAttribute("data3", str);

%>
<h1>MVC1모델 결과입니다.</h1>
<ol>
  <li><%=str %></li>
  <li>${data3 }</li>
  <li>${data }</li>
  <li>${data2[0] }</li>
  <li>${data2[1] }</li>
  <li>${data2[2] }</li>
</ol>


</body>
</html>