<%@ page language="java" contentType="text/html; charset=UTF-8"    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 브레인 마이닝 깃허브 테스트 </h1>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<a href="${path }/emp/emplist.go">직원조회</a><br>
<a href="${path }/emp/empInsert.go">직원등록</a><br>
<a href="${path }/emp/empInsert.go">직원수정</a><br>
<img alt="" src="${path }/images/200x200bb.jpg" >

</body>
</html>