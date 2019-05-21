<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>게시물 상세 보기</h1>
<form action="boardInsert" method="post" >
제목 : <input type="text" name="title" value="${board.title }"><br>
내용 : <textarea name="contents" rows="10" cols="80">${board.contents }</textarea><br>
작성자: <input type="text" name="writer" value="${board.writer }"><br>
<input type="submit" value="등록하기" >
</form>


</body>
</html>