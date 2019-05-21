<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
<style>
  table, tr{
    border-collapse: collapse;
  }
</style>
</head>
<body>
<h1> 사용자의 등록정보 </h1>
<%=request.getAttribute("uid") %>

<table border="1">
 <tr>
   <td>사용자번호</td>
   <td>${uid }</td>
 </tr>
 <tr>
   <td>사용자비밀번호</td>
   <td>${upass }</td>
 </tr>
   <tr>
   <td>사용자이름</td>
   <td>${uname }</td>
 </tr>
 <tr>
   <td>성별</td>
   <td>${gender }</td>
 </tr>
   <tr>
   <td>취미</td>
   <td>${hobby[0]}*
   ${hobby[1] }*
   ${hobby[2] }*
   ${hobby[3] }*
   </td>
 </tr>
 <tr>
   <td>종교</td>
   <td>${religion }</td>
 </tr>
   <tr>
   <td>자기소개</td>
   <td>${introduction }</td>
 </tr>
</table>
</body>
</html>








