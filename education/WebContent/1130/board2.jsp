<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
 
</head>
<body>
<h1>borad2</h1>
<jsp:useBean id="board" class="com.encore.model.BoardVO" scope="request"/>
<jsp:getProperty property="bnum" name="board" /><br>
<jsp:getProperty property="title" name="board" /><br>
<jsp:getProperty property="contents" name="board" /><br> 
<jsp:getProperty property="writer" name="board" /><br>
<jsp:getProperty property="regdate" name="board"/><br>
<jsp:getProperty property="count" name="board" /><br>

 
</body>
</html>







