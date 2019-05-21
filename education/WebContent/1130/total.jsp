<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>

</head>
<body>
<h1>매출 관리 시스템</h1>
<h2>총매출 : ${totalPrice} </h2>
<form action="total2">
 짜장면(500)<input type="radio" name="item" value="500" checked="checked"><br>
 짬봉(700)<input type="radio" name="item" value="700"><br>
 초기화<input type="radio" name="item" value="0"><br>
<input type="submit" value="Submit">
</form>
</body>
</html>


