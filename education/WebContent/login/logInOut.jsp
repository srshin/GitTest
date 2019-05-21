<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html>
<html>
<head>
<meta charset="UTF-8">
<title>회원인증</title>
</head>
<body>
<form action="logProc" method="post">
 ID : 
 <input type="text" name="id" value="${id }"   placeholder="아이디필수"  required="required"> <br>
 비밀번호 : <input type="password"  value="${pwd }"  name="pwd" placeholder="비밀번호필수"  required="required"> <br>
<input type="submit" value="로그인">
</form>

</body>
</html>



