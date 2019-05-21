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
<script>
function call(studentId) {
	ret = confirm("삭제하시겠습니까? ");
	if(ret)
	location.href='deleteStudent.do?studentId='+studentId;
}


</script>
</head>
<body>
<h1> 학생 조회/수정/삭제 </h1>
<hr>
<a href="indexAdmin.jsp"> 메인화면 </a>
<div id="here"> 
<table>
 <tr>
   <td>학생아이디</td><td>비번</td><td>이름</td><td>전공아이디</td><td>전공타이틀</td><td>전화번호</td><td>주소</td><td>취미</td><td>기술</td><td></td>
 </tr>
 <c:forEach items="${studentList}" var="vo">
 <tr>
   <td><a href="selectStudentById.do?studentId=${vo.studentId}">${vo.studentId}</a></td>
   <td>${vo.password}</td>
   <td>${vo.name}</td>
   <td>${vo.majorId}</td>
   <td>${vo.majorTitle}</td>
   <td>${vo.phone}</td>
   <td>${vo.address}</td>
   <td>${vo.hobby}</td>
   <td>${vo.skill}</td>
   <td><button onclick="call(${vo.studentId});">삭제</button></td>
 </tr>
 </c:forEach>
</table>
</div>
</body>
</html>
