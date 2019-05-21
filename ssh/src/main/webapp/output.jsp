<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8" isELIgnored="false"%>
<%@ taglib prefix="c"  uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>SSH TEST</title>
<%
pageContext.setAttribute("defaultCommand", "ls -l  -t ");
%>
</head>
<body>
<h1> SSH TEST </h1>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>

<a href="${path }/csvMonitor.go">MONITORING CSV</a><br> 


<hr>
${result1 }
<hr>
${result2 }


</body>
</html>