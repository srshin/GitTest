<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>

<!DOCTYPE html>
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<c:if test="${sessionScope.admin==null}">
 <c:redirect url="/index.jsp">
</c:redirect>
</c:if> 
<h1> 관리자 메뉴 </h1>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>


<hr>
<ol>
<li><a href="${path }/admin/dbSaveMajorStudent.do">major.csv  student.csv DB저장</a></li>
<li><a href="${path }/admin/insertMajor.do">major 등록</a></li>
<li><a href="${path }/admin/selectMajor.do">major 조회/수정/삭제</a></li>
<li><a href="${path }/admin/insertStudent.do">Student 등록</a></li>
<li><a href="${path }/admin/selectStudent.do">Student 조회/수정.삭제</a></li>

</ol>



</body>
</html>