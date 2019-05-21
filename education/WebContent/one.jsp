<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%
//자바땅입니다.
String name = "남기";
%>    
<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>

<!-- HTML의 기본경로는 http://ip:port    -->
<!-- 서블릿은 http://ip[:port/educaion  -->
<jsp:include page="/header.jsp"></jsp:include> 



<h1>JSP페이지입니다. <%=name %>   </h1>
<!-- HTML주석입니다. -->
<h2>test</h2>
나의 이름은 ${myname } 입니다.  <br>
나의 이름은 ${myname2 } 입니다.  <br>
나의 이름은 ${myname3 } 입니다.  <br>


</body>
</html>


