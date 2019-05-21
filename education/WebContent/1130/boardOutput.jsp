<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core"  %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<table border="1">
    <tr>
      <td>번호</td><td>제목</td><td>내용</td><td>작성자</td><td>작성일</td>
    </tr>
	<c:forEach var="board"  items="${blist }">
		<tr>
	      <td>${board.bnum}</td>
	      <td>${board.title}</td>
	      <td>${board.contents}</td>
	      <td>${board.writer}</td>
	      <td>${board.regdate}</td>
	    </tr>   
	
	</c:forEach>
</table>
</body>
</html>





