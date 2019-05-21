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

<%-- <jsp:include page="header.jsp"></jsp:include> 
 --%>
<c:if test="${sessionScope.student==null}">
 <c:redirect url="/index.jsp">
</c:redirect>
</c:if> 
<h1> 학생 메뉴 </h1>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<hr>

<ol>

<li><a href="${path }/student/selectStudentMajor.do">정보 조회 </a></li>
<li><a href="${path }/student/SelectByStudentId.do">내정보 수정</a></li>

</ol>



</body>
</html>