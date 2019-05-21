<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>첫번째 페이지</h1>
<%@include file="two.jsp" %>
두번째 페이지에서 : <%=count %> 입니다.
<jsp:include page="three.jsp"></jsp:include>
<%-- 세번째 페이지에서 : <%=score %> 입니다.  --%>
<%@include file="three.jsp" %>
세번째 페이지에서 : <%=score %> 입니다.

</body>
</html>