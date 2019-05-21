<%@page import="com.encore.model.BookDTO"%>
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
/*  BookDTO book = new BookDTO();
book.getTitle();
book.setTitle("서블릿");  
book.setTitle("서블릿2"); 
*/ 
%>
<jsp:useBean id="book" class="com.encore.model.BookDTO"></jsp:useBean>
title : <jsp:getProperty property="title" name="book"/>
author : <jsp:getProperty property="author" name="book"/><br>
publisher : <jsp:getProperty property="publisher" name="book"/><br>

<hr>
<jsp:setProperty property="title" name="book" param="title"/>
<jsp:setProperty property="author" name="book" param="author"/>
<jsp:setProperty property="publisher" name="book" param="publisher"/>
title : <jsp:getProperty property="title" name="book"/><br>
author : <jsp:getProperty property="author" name="book"/><br>
publisher : <jsp:getProperty property="publisher" name="book"/><br>
<hr>

<jsp:useBean id="book2" class="com.encore.model.BookDTO"></jsp:useBean>
<jsp:setProperty property="*" name="book2" />
 
title : <jsp:getProperty property="title" name="book2"/><br>
author : <jsp:getProperty property="author" name="book2"/><br>
publisher : <jsp:getProperty property="publisher" name="book2"/><br>
</body>
</html>







