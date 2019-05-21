<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>2페이지 </h1>
<pre>
 
application : ${book}   ----- <%=application.getAttribute("book") %>
session : ${book2}      ----- <%=session.getAttribute("book2") %>
request : ${book3}      ----- <%=request.getAttribute("book3") %>
pageContext : ${book4}  ----- <%=pageContext.getAttribute("book4") %>
</pre>
</body>
</html>






