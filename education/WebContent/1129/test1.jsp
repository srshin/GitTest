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
BookDTO book = new BookDTO("서블릿","남기","엔코아");
application.setAttribute("book", book);
session.setAttribute("book2", book);
request.setAttribute("book3", book);
pageContext.setAttribute("book4", book);
%>
<h1>1페이지</h1>
<pre>
application : ${book}   ----- <%=application.getAttribute("book") %>
session : ${book2}      ----- <%=session.getAttribute("book2") %>
request : ${book3}      ----- <%=request.getAttribute("book3") %>
pageContext : ${book4}  ----- <%=pageContext.getAttribute("book4") %>
<hr>
<%-- <jsp:forward page="test2.jsp"/> --%>
<jsp:include page="test2.jsp"/>
</pre>
</body>
</html>







