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
function call(majorId) {
	ret = confirm("삭제하시겠습니까? ");
	if(ret)
	location.href='deleteMajor.do?majorId='+majorId;
}


</script>
</head>
<body>
<h1> 부서 조회/수정/삭제 </h1>
<hr>
<a href="indexAdmin.jsp"> 메인화면 </a>
<div id="here"> 
<table>
 <tr>
   <td>전공아이디</td><td>전공타이틀</td>
 </tr>
 <c:forEach items="${majorList}" var="vo">
 <tr>
   <td><a href="selectById.do?majorId=${vo.majorId}">${vo.majorId}</a></td>
   <td>${vo.majorTitle}</td>
   <td><button onclick="call(${vo.majorId});">삭제</button></td>
 </tr>
 </c:forEach>
</table>
</div>
</body>
</html>
