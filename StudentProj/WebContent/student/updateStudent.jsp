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
<form action="updateStudent.do" method="post">
학생 아이디 <input type="text" name="studentId" value="${sessionScope.student.studentId}" readonly="readonly"> <br>
비밀번호 <input type="password" name="password" value="${sessionScope.student.password}"> <br>
이름   <input type="text" name="name" value="${sessionScope.student.name}"><br>
전공 아이디<input type="text" name="majorId" value="${sessionScope.student.majorId}"><br>
전화번호  <input type="text" name="phone" value="${sessionScope.student.phone}"><br>
주소  <input type="text" name="address" value="${sessionScope.student.address}"><br>
취미  <input type="text" name="hobby" value="${sessionScope.student.hobby}"><br>
기술  <input type="text" name="skill" value="${sessionScope.student.skill}"><br>
<input type="submit" value="확인">
</form>
</body>
</html>