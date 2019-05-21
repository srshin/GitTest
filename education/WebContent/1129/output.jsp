<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<!DOCTYPE html PUBLIC "-//W3C//DTD HTML 4.01 Transitional//EN" "http://www.w3.org/TR/html4/loose.dtd">
<html>
<head>
<meta http-equiv="Content-Type" content="text/html; charset=UTF-8">
<title>Insert title here</title>
</head>
<body>
<p>음료자판기...결과화면</p>
넣은입력 ${params.price } <br>
<p>선택상품들 : 
<%
String[] items = (String[])request.getAttribute("items");
for(String s:items){
   out.print("구매함:" + s + "<br>");
}%>

 

<p>잔액: ${change }</p>
<br>
</body>
</html>





