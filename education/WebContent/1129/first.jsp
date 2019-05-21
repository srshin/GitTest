<%@page import="java.sql.Date"%>
<%@page import="com.encore.model.BookDTO"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//Scriptlet....
/*자바소스작성*/ 
String name = "엔코아";
BookDTO book = new BookDTO("자바","저자","출판사");
Date d = new Date(new java.util.Date().getTime());
pageContext.setAttribute("today", d);
pageContext.setAttribute("book", book);
%>    


<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<!-- HTML주석 :HTML문서에 대한 설명-->
<%--JSP주석:JSP문서에 대한 설명  --%>
<%--expression이용하여 출력한다.  --%>
<%=name %><br>
오늘은 <%=d %> 입니다. <br> 
<%--EL(Expression Language) --%>
<%=pageContext.getAttribute("today") %><br>
${today} <br>
<%=pageContext.getAttribute("book") %>
${book} <br>

<%--include지시자  --%>
<%@include file="/copyright.jsp" %><br>
<%--JSP 표준태그 --%>
<jsp:include page="/copyright.jsp"></jsp:include>


<%!
//선언문
//멤버변수 + 메서드 
String company = "엔코아";

public int sum(int a, int b){
	return a+b;
}
%>

<%=company %> <br>
10+20 = <%=sum(10,20) %> <br>
100+200 = <%=sum(100,200) %> <br>



</body>
</html>






