<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<%@taglib prefix="fn" uri="http://java.sun.com/jsp/jstl/functions" %>

<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

<script>
function deleteBno(bno) {
	ret = confirm("삭제하시겠습니까? ");
	if(ret)
	location.href='boardDelete?bno='+bno;
}



</script>

</head>
<body>


<h1>게시판 목록</h1>
<table border="1">
 <tr>
   <td>게시물번호</td> <td>제목</td> <td>내용</td> <td>작성자</td> <td>작성일</td><td>조회수</td>
 </tr>
 <c:forEach items="${list}" var="b">
 <tr>
   <td><a href="selectById?bno=${b.bno}">${b.bno}</a></td>
   <td>${b.title }</td>
   <td>${b.contents }</td>
   <td>${b.writer }</td>
   <td>
      <fmt:formatDate pattern="yyy/MM/dd hh:mm:ss" value="${b.regdate}" />
   </td>
   <td>${b.count }</td>
   <td><button onclick="deleteBno(${b.bno});">삭제</button></td>
   
 </tr>
 
 </c:forEach>

</table>



</body>
</html>