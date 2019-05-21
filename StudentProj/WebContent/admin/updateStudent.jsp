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
<h1>전공 등록</h1>
<hr>
<form action="updateStudent.do" method="post">
학생 아이디 <input type="text" name="studentId" value="${vo.studentId}" readonly="readonly"> <br>
비밀번호 <input type="password" name="password" value="${vo.password}"> <br>
이름   <input type="text" name="name" value="${vo.name}"><br>
전공 
<select name="majorId" required="required">
	<c:forEach var="d" items="${majorList }">
		<option value="${d.majorId }"  ${d.majorId==vo.majorId?"selected":"" } >${d.majorTitle }</option>
	</c:forEach>
</select>
<br>
전화번호  <input type="text" name="phone" value="${vo.phone}"><br>
주소  <input type="text" name="address" value="${vo.address}"><br>
취미  <input type="text" name="hobby" value="${vo.hobby}"><br>
기술  <input type="text" name="skill" value="${vo.skill}"><br>
<input type="submit" value="확인">
</form>
</body>
</html>