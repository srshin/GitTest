<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1> 게시판 관리</h1>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<a href="${path }/board/boardList">게시판조회</a>
<a href="${path }/board/boardInsert">게시물등록</a>

</body>
</html>