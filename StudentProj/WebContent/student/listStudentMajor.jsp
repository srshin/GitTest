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
function retreive() {
	  var xhttp = new XMLHttpRequest();
	  xhttp.onreadystatechange = function() {
	    if (this.readyState == 4 && this.status == 200) {
	      document.getElementById("here").innerHTML = this.responseText;
	    }
	  };
	var majorId = document.getElementById("majorId").value;
	var studentId = document.getElementById("studentId").value;
	var name = document.getElementById("name").value;
	
	var param = "majorId="+majorId+"&studentId="+studentId+"&name="+name;
	alert(param);
	  xhttp.open("GET", "selectStudentMajor2.do?"+param);
	  xhttp.send();
	
	
}

</script>

</head>
<body>
학생 아이디 선택 : 
<select name="studentId" id="studentId">
		<option value="all">학생전체</option>
	<c:forEach var="d" items="${studentList }">
		<option value="${d.studentId }">${d.studentId }</option>
	</c:forEach>
</select>
전공 선택 :
<select name="majorId" id="majorId">
		<option value="all">전공전체</option>
	<c:forEach var="d" items="${majorList }">
		<option value="${d.majorId }">${d.majorTitle }</option>
	</c:forEach>
</select>

 학생이름 : <input type="text" value="" id="name">
<button onclick="retreive();">조회</button>

<h1> 학생 조회 </h1>
<hr>
<div id="here"> 
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
</div>
</body>
</html>
