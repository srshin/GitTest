<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<table>
 <tr>
   <td>학생아이디</td><td>이름</td><td>기술</td><td>전공아이디</td><td>전공타이틀</td>
 </tr>
 <c:forEach items="${studentMajorList}" var="vo">
 <tr>
   <td>${vo.studentId}</td>
   <td>${vo.name}</td>
   <td>${vo.skill}</td>
   <td>${vo.majorId}</td>
   <td>${vo.majorTitle}</td>
 </tr>
 </c:forEach>
</table>
