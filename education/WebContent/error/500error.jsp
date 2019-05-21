<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8" isErrorPage="true"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<%
String uri = 
(String)request.getAttribute("javax.servlet.error.request_uri");
%>

<h1>500 에러입니다. </h1>
<%=exception.getMessage() %> <br>
<%=exception.getStackTrace().toString() %><br>
${pageContext.exception.message}<br>
${pageContext.exception.stackTrace}<br>
${pageContext.exception.cause.message}<br>
<%=uri %><br>
</body>
</html>