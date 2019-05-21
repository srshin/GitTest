<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html >
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<h1>학생 등록</h1>
<hr>
<form action="insertStudent.do" method="post">
학생 아이디 <input type="text" name="studentId" required="required"> <br>
학생 비밀번호 <input type="password" name="password"> <br>
이름   <input type="text" name="name" required="required"><br>
전공
<select name="majorId" required="required">
	<c:forEach var="d" items="${majorList }">
		<option value="${d.majorId }">${d.majorTitle }</option>
	</c:forEach>
</select>
<br>
전화번호  <input type="text" name="phone"><br>
주소  <input type="text" name="address"><br>
취미  <input type="text" name="hobby"><br>
기술  <input type="text" name="skill"><br>
<input type="submit" value="확인">
</form>
</body>
</html>