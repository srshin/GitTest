<%@page import="java.sql.Date"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<%Date d = new Date(new java.util.Date().getTime());
request.setAttribute("today", d);
%>
</head>
<body>
<jsp:useBean id="board" class="com.encore.model.BoardVO" scope="request"/>
<jsp:setProperty property="bnum" name="board" value="2"/>
<jsp:setProperty property="title" name="board" value="R스터디"/>
<jsp:setProperty property="contents" name="board" value="너무재밋어"/>
<jsp:setProperty property="writer" name="board" value="인아"/>
<jsp:setProperty property="regdate" name="board" value="${today}"/>
<jsp:setProperty property="count" name="board" value="20"/>
<jsp:forward page="board2.jsp"/>
</body>
</html>







