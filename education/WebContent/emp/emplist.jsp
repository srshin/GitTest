<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<script>
function call(empid) {
	ret = confirm("삭제하시겠습니까? ");
	if(ret)
	location.href='empDelete.go?empid='+empid;
}



</script>
</head>
<body>
<c:set var="path" value="${pageContext.request.contextPath }"></c:set>
<!-- HTML의 기본경로는 http://ip:port    -->
<!-- 서블릿은 http://ip[:port/educaion  -->
<jsp:include page="/header.jsp"></jsp:include><br>
<a href="${path }/emp/empInsert.go">직원등록</a><br>

<h1>직원 목록</h1>
<table border="1">
 <tr>
   <td>직원번호</td>
   <td>이름</td>
   <td>성</td>
   <td>이메일</td>
   <td>이메일2</td>
   <td>전화번호</td>
   <td>직급</td>
   <td>입사일</td>
   <td>부서</td>
   <td>급여</td>
   <td>메니져</td>
   <td>커미션</td>
   <td>삭제기능</td>
   
 </tr>
 <c:forEach items="${emps}" var="emp">
 <tr>
   <td><a href="empById.go?empid=${emp.employee_id}">${emp.employee_id}</a></td>
   <td>${emp.first_name }</td>
   <td>${emp.last_name }</td>
   <td>${emp.email }</td>
   <td> ${fn:substring(emp.email,0,2)}</td>
   <td>${emp.phone_number }</td>
   <td>${emp.job_id }</td>
   <td>
      <fmt:formatDate pattern="yyy/MM/dd hh:mm:ss" 
      value="${emp.hire_date}" />
   </td>
   <td>${emp.department_id }</td>
   <td>
	   <fmt:setLocale value="en_US"/>
	   <fmt:formatNumber value="${emp.salary }" type="currency" />
   </td>
   <td>${emp.manager_id }</td>
   <td>${emp.commission_pct }</td>
   <td><button onclick="call(${emp.employee_id});">삭제</button></td>
 </tr>
 
 </c:forEach>

</table>



</body>
</html>






