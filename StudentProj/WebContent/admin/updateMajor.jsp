<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>전공 등록</h1>
<hr>
<form action="updateMajor.do" method="post">
전공 아이디 <input type="text" name="majorId" value="${vo.majorId}" readonly="readonly"> <br>
전공 타이틀  <input type="text" name="majorTitle" value="${vo.majorTitle}"><br>
<input type="submit" value="확인">
</form>
</body>
</html>